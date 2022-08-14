package ds.smartwarehouse.project.warehouseManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.google.rpc.Code;
import com.google.rpc.Status;

import ds.smartwarehouse.project.AGVSystem.AGVServer;
import ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest;
import ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse;
import ds.smartwarehouse.project.orderManagement.OrderManagementServer;
import ds.smartwarehouse.project.orderManagement.OrderTrackingRequest;
import ds.smartwarehouse.project.orderManagement.OrderTrackingResponse;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.protobuf.StatusProto;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class WarehouseManagementServer extends WarehouseManagmentImplBase {
	
	//Logger for metadata 
	private static final Logger logger = Logger.getLogger(WarehouseManagementServer.class.getName());
	
	/*Metadata reading client*/
	class WarehouseManagementInterceptor implements ServerInterceptor{
	      @Override
	      public <ReqT, RespT> Listener<ReqT> 
	      interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
	 
	         logger.info("Recieved following metadata: " + headers);
	         return next.startCall(call, headers);
	      }

	   }

	//main method
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of the Server class
		WarehouseManagementServer WMserver = new WarehouseManagementServer();
				
		//calling jmDNS register service on server 
		WMserver.registerService();

		//port number 
		int port = 50051;
		
		//build server 
		Server server = ServerBuilder.forPort(port)
				.addService(WMserver)
				.build()
				.start();
		
		System.out.println("New Warehouse Management server started listening on port: " + port +"\n");
		
		server.awaitTermination();

	}
	//jmDNS registration 
	private  void registerService() {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_http._tcp.local.";//"_http._tcp.local.";
	            String service_name = "Warehouse Managment Server";// "example";
	            int service_port = 50051;
	            //int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description = "Smart Warehouse Managment Service: Server ";//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("Registering new AGV service with type %s and name %s \n", service_type, service_name);
	            System.out.printf("Service Type: " + service_type + "\n");
	            System.out.printf("Service Name: "+  service_name + "\n");
	            System.out.printf("Service Port: "+  service_port + "\n");
	            System.out.printf("Service Description: "+  service_description +"\n");
	            
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/*Unary*/
	@Override
	public void productivityReport(ProductivityReportRequest request,
			StreamObserver<ProductivityReportResponse> responseObserver) {
		//Object of OMserver class 
		OrderManagementServer OSserver = new OrderManagementServer();
		Date date = new Date(); 

		//receive report and earnings from client 
		System.out.println("Receiving productivity message: " + request.getProdReport());
		double q1 = request.getQ1Earning();
		double q2 = request.getQ2Earning();
		double q3 = request.getQ3Earning();
		double q4 = request.getQ4Earning();
		//build response
		
		double qrtAvg = (q1+q2+q3+q4)/4;//Quarterly Average Earnings 
		double pcmAvg = (q1+q2+q3+q4)/12;//Monthly(per calendar month) Average Earnings 
		double total = (q1+q2+q3+q4);//Total Annual Earnings 
		
		//build Unary response to client 
		ProductivityReportResponse response = ProductivityReportResponse.newBuilder()
				.setProdReportService("Productivity Report for "+date + ". Request Recieved from Client.")
				.setEmployeeCount(OSserver.randomNum())
				.setAGVperformance(OSserver.randomNum())
				.setQ1Earning(q1)
				.setQ2Earning(q2)
				.setQ3Earning(q3)
				.setQ4Earning(q4)
				.setQuartAvg(qrtAvg)
				.setAnnualAvgEarning(pcmAvg)
				.setTotalEarning(total)
				.build();
		
		//send
		responseObserver.onNext(response);
		//complete
		responseObserver.onCompleted();
		
	}

	/*Client Streaming*/
	@Override
	public StreamObserver<DemandForecastRequest> demandForecast(
			StreamObserver<DemandForecastResponse> responseObserver) {
		
		return new StreamObserver<DemandForecastRequest>(){

			//ArrayList to add items that are selling 
			ArrayList <Integer> list = new ArrayList<>();

			//store date to display
			Date date = new Date();
			 
			@Override
			public void onNext(DemandForecastRequest value) {

				//receive forecast request from client 
				 String forecastRequest = value.getForecastMessage();
				 
				 //receive items that have been sold 
				 int items = value.getItemsSold();
					if (items<0) {//if user enters negative value, system will catch and display error
			            try {
			                Status status = Status.newBuilder()
			                    .setCode(Code.INVALID_ARGUMENT_VALUE)//grpc code for invalid argument
			                    .setMessage("Invalid numner of items, please enter a value greater than 0") //build error message                  
			                    .build();
			                //send response
			                responseObserver.onError(StatusProto.toStatusRuntimeException(status));
			            } catch (StatusRuntimeException ex) {
			            	ex.printStackTrace(); }
		            }
				 
				 System.out.println("Forecast Request from client: " + forecastRequest + " on " + date);

				 //add number of items to list 
				 list.add(items);

				 try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

			@Override
			public void onError(Throwable t) {

				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				
				//calculate variable 
				int total = 0;

				//enhanced for loop to add all item quantity 
				for(int itemsSold : list) {
					total += itemsSold;
				}
				
				//send response with items that are in demand 
				 DemandForecastResponse response = DemandForecastResponse.newBuilder()
						 .setForecastReview("Requested review at :" + date +". ")
						 .setHighDemand(total)
						 .build();
				 
				 //sending
				 responseObserver.onNext(response);

				System.out.println("Finished Demand Forecasting Client streaming service.\n");
				responseObserver.onCompleted();
			
			}
			
		};
	}

	/*Bi-Directional*/
	@Override
	public StreamObserver<RealTimeOverviewRequest> realTimeOverview(
			StreamObserver<RealTimeOverviewResponse> responseObserver) {
	 
		return new StreamObserver<RealTimeOverviewRequest>(){
 
			@Override
			public void onNext(RealTimeOverviewRequest value) {
				 Date date = new Date(); 
				 Random rand = new Random();
				 String reply;

				 //store Overview message 
				 String OViewMsg = value.getOverviewMessage();
				 
				 //depending on what sort of overview the client wants, it will determine the outcome of the report 
				 //employee overview example
				 if(OViewMsg.equalsIgnoreCase("Employee")) {
					 reply = ("Employee Head Count " + rand.nextInt(100) + ". Production Line fully operational.");
				 }
				 //AGV overview example
				 else if (OViewMsg.equalsIgnoreCase("AGV Overview")) {
					 reply = ("AGV systems online: " + rand.nextBoolean() + ". Awaiting instructions.");

				 }
				 //Temperature control example 
				 else if (OViewMsg.equalsIgnoreCase("Temperature Control")) {
					 reply = ("Temperature Control Stream. Warehouse Temp: " + rand.nextInt(10, 30)+ " degrees Celcius. Temperature is optimal: " + rand.nextBoolean() +".");

				 }
				 //overview type not specified in server 
				 else {
					 reply = "Could not interpret request, please try again.";
				 }
				 
				 System.out.println("Overview Message Request from client: " + OViewMsg + " at " + date);
				 
				 //return response depending on overview type 
				 RealTimeOverviewResponse response = RealTimeOverviewResponse.newBuilder()
						 .setWarehouseOverview(reply)
						 .setVehicleOverview("Testing " + OViewMsg + " Systems: ")
						 .build();
				 
				 responseObserver.onNext(response);
				 try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

			@Override
			public void onError(Throwable t) {

				t.printStackTrace();
			}

			@Override
			public void onCompleted() {

				//finished bi-directional streaming 
				System.out.println("Finished Bi-Directional RealTime overview service.\n");
				responseObserver.onCompleted();
			
			}
			
		
		};
	}
	
	
}
