package ds.smartwarehouse.project.warehouseManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.smartwarehouse.project.AGVSystem.AGVServer;
import ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest;
import ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse;
import ds.smartwarehouse.project.orderManagement.OrderManagementServer;
import ds.smartwarehouse.project.orderManagement.OrderTrackingRequest;
import ds.smartwarehouse.project.orderManagement.OrderTrackingResponse;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class WarehouseManagementServer extends WarehouseManagmentImplBase {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create object of the Server class
		WarehouseManagementServer WMserver = new WarehouseManagementServer();
				
		WMserver.registerService();

			
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(WMserver)
				.build()
				.start();
		
		System.out.println("New Warehouse Management server started listening on port: " + port +"\n");
		
		server.awaitTermination();

	}
	
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

	//Unary
	@Override
	public void productivityReport(ProductivityReportRequest request,
			StreamObserver<ProductivityReportResponse> responseObserver) {
		
		OrderManagementServer OSserver = new OrderManagementServer();
		Date date = new Date(); 



		//receive
		System.out.println("Receiving productivity message: " + request.getProdReport());
		double q1 = request.getQ1Earning();
		double q2 = request.getQ2Earning();
		double q3 = request.getQ3Earning();
		double q4 = request.getQ4Earning();
		//build response
		
		double qrtAvg = (q1+q2+q3+q4)/4;
		double pcmAvg = (q1+q2+q3+q4)/12;
		double total = (q1+q2+q3+q4);
		
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

	//Client Streaming
	@Override
	public StreamObserver<DemandForecastRequest> demandForecast(
			StreamObserver<DemandForecastResponse> responseObserver) {
		
		return new StreamObserver<DemandForecastRequest>(){

			ArrayList <Integer> list = new ArrayList<>();


			Date date = new Date();
			 
			@Override
			public void onNext(DemandForecastRequest value) {

				 String forecastRequest = value.getForecastMessage();
				 
				 int items = value.getItemsSold();
				 
				 System.out.println("Forecast Request from client: " + forecastRequest + " on " + date);
				 
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
				
				int total = 0;

				for(int itemsSold : list) {
					total += itemsSold;
				}
				
				
				 DemandForecastResponse response = DemandForecastResponse.newBuilder()
						 .setForecastReview("Requested review at :" + date +". ")
						 .setHighDemand(total)
						 .build();
				 
				 responseObserver.onNext(response);
				System.out.println("Finished Demand Forecasting Client streaming service.\n");
				responseObserver.onCompleted();
			
			}
			
		
		};
	}

	//Bi-Directional
	@Override
	public StreamObserver<RealTimeOverviewRequest> realTimeOverview(
			StreamObserver<RealTimeOverviewResponse> responseObserver) {
		
		return new StreamObserver<RealTimeOverviewRequest>(){
 
			@Override
			public void onNext(RealTimeOverviewRequest value) {
				 Date date = new Date(); 
				 Random rand = new Random();

				 
				 String OViewMsg = value.getOverviewMessage();
				 
				 System.out.println("Overview Message message request: " + OViewMsg);
				 
				 
				 RealTimeOverviewResponse response = RealTimeOverviewResponse.newBuilder()
						 .setVehicleOverview("Vehicle Overview")
						 .setWarehouseOverview("WH Overview")
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

				System.out.println("Finished Bi-Directional RealTime overview service.\n");
				responseObserver.onCompleted();
			
			}
			
		
		};
	}
	
	
}
