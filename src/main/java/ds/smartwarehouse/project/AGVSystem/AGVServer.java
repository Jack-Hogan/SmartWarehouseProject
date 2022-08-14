package ds.smartwarehouse.project.AGVSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.google.rpc.Code;
import com.google.rpc.Status;

import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc.AGVSystemImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;


public class AGVServer extends AGVSystemImplBase {

	//Logger for Metadata 
	private static final Logger logger = Logger.getLogger(AGVServer.class.getName());

	/*Metadata Interceptor reading client*/
	class AGVInterceptor implements ServerInterceptor{
	      @Override
	      public <ReqT, RespT> Listener<ReqT>
	      interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

	         logger.info("Recieved following metadata: " + headers);
	         return next.startCall(call, headers);
	      }

	   }


	//main method
	public static void main(String[] args) throws IOException, InterruptedException {

		//create an instance of the Server class
		AGVServer serverAGV = new AGVServer();

		//call registerService on server 
		serverAGV.registerService();

		//port 
		int port = 50051;

		//build server and start
		Server server = ServerBuilder.forPort(port)
				.addService(serverAGV)
				//.intercept(new AuthorizationServerInterceptor())
				.build()
				.start();

		System.out.println("New AGV server started listening on port: " + port +"\n");

		server.awaitTermination();


	}

	//Array of AGV 
	public String AGVarray() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Automated Guided Carts");
		list.add("Heavy Burden Carriers");
		list.add("Autonomous Mobile Robots");
		list.add("Vision Guided Tow Tractor");
		list.add("Lazor Guided Conveyor");

		String RandomAGV;
		Random rand = new Random();
		int index = rand.nextInt(4);

		RandomAGV = list.get(index);
		return RandomAGV;
	}

	/*Bi-Directional*/
	@Override
	public StreamObserver<VehicleTrackingRequest> vehicleTracking(
			StreamObserver<VehicleTrackingResponse> responseObserver) {

		//return stream requests from client
		return new StreamObserver<VehicleTrackingRequest>(){

			@Override
			public void onNext(VehicleTrackingRequest value) {
				 Date date = new Date();

				 //Receive AGV type from client 
				 String type = value.getAGVtype();

				 System.out.println("Vehicle tracking request for " + type + " AGV at: " + date + "\n");

				 //Math random to create random longitude and latitude values
				    double minLat = -90.00;
				    double maxLat = 90.00;
				    double latitude = minLat + Math.random() * ((maxLat - minLat) + 1);
				    double minLon = 0.00;
				    double maxLon = 180.00;
				    double longitude = minLon + Math.random() * ((maxLon - minLon) + 1);

				 //build response back to client 
				 VehicleTrackingResponse response = VehicleTrackingResponse.newBuilder()
						 .setAGVtype(type)
						 .setAGVlatitude(latitude)
						 .setAGVlongitude(longitude)
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
				//Bi-Directional Finished
				System.out.println("Finished Bi-Directional vehicle tracking service.\n");
				responseObserver.onCompleted();

			}

		};
	}

	/*Unary*/
	@Override
	public void agvProductivity(AGVProductivityRequest request,
			StreamObserver<AGVProductivityResponse> responseObserver) {

		Random rand = new Random();
		Date date = new Date();

		//Report Variables
		int id = rand.nextInt((1000-500)+1);
		int agvSerial = rand.nextInt(400);
		int agvSerial2 = rand.nextInt(400);
		boolean perform = rand.nextBoolean();
		boolean stock = rand.nextBoolean();
		String AGV2 = AGVarray();
		String AGV = AGVarray();

		//receiving report request
		System.out.println("Request Message from Client: " + request.getAGVreport());

		//build response
		AGVProductivityResponse response = AGVProductivityResponse.newBuilder()
				.setAGVreportReply("\nReport no." + id + " for " + date + " for AGV is as follows: \n")
				.setPerformance("Performance Over 85%: " + perform + ".\nMost Effcient AGV: "+AGV +" no." +agvSerial2 +"\n")
				.setStock("Low Stock Capacity Alert: " + stock +"\n")
				.setMaintenance("Maintence team working on software update for: " + AGV2 + " no." + agvSerial)
				.build();

//		/*Deadline Exceeded Exception Example*/
//		try {
//			Thread.sleep(4000);
//		}
//		catch(InterruptedException e) {
//			e.printStackTrace();
//		}

		//send response message
		responseObserver.onNext(response);

		//completed
		responseObserver.onCompleted();
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

	/*Server streaming*/
	@Override
	public void agvDiag(AGVDiagRequest request, StreamObserver<AGVDiagResponse> responseObserver) {
		
		//server responses requested 
		int requestAmount = request.getAGVfrequency();
		//error handling 
		if (requestAmount < 0 || requestAmount > 50) {//if user enters negative value or too high, system will catch and display error
            try {
                Status status = Status.newBuilder()
                    .setCode(Code.INVALID_ARGUMENT_VALUE)//grpc code for invalid argument
                    .setMessage("Invalid amount of vehicle requests, please enter a value between 0 and 50") //build error message                  
                    .build();
                //send response
                responseObserver.onError(StatusProto.toStatusRuntimeException(status));
            } catch (StatusRuntimeException ex) {
            	ex.printStackTrace(); }
		}
		int counter = 1;
		Random rand = new Random();

		//Request message print out
		System.out.println("\nReceiving request message from Client: " + request.getAGVdiagRequest() + " for " +requestAmount +" vehicles. Request Recieved Successfully");

		//for loop to build each response back to client
		for(int i = 0; i < requestAmount; i++) {

			int random = rand.nextInt(100);
			String AGV = AGVarray();
			String status = "";
			if(random<10) {
				status = "Offline!";
			}
			else if(random<20) {
				status = "Critical!";
			}
			else if(random <40) {
				status = "Warning!";
			}
			else if(random <60) {
				status = "Suffcient";
			}
			else {
				status = "Optimal";
			}

			//Response builder 
			AGVDiagResponse response = AGVDiagResponse.newBuilder()
					.setAGVdiagType("Request " + counter + " process. AGV diagnosis online. " + AGV + " System at " + random + "% capacity. Status: " + status)
					.setSystemPerformance(random)
					.build();
			counter++;//counter to keep track of message number 
			responseObserver.onNext(response);


			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		responseObserver.onCompleted();
		
		

	}

	private  void registerService() {

		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

	            String service_type = "_http._tcp.local.";//"_http._tcp.local.";
	            String service_name = "AGV System Server";// "example";
	            int service_port = 50051;
	            
	            //Description of service
	            String service_description = "AGV System Service : Server ";//"path=index.html";

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



}
