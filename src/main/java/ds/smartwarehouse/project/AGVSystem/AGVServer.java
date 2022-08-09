package ds.smartwarehouse.project.AGVSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.util.Date;
import java.util.Properties;

import ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse.Builder;
import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc.AGVSystemImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AGVServer extends AGVSystemImplBase {
	
	//import Server class
	//private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of the Server class
		AGVServer serverAGV = new AGVServer();
		
		serverAGV.registerService();

		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(serverAGV)
				.build()
				.start();
		
		System.out.println("New AGV server started listening on port: " + port);
		
		server.awaitTermination();
		

	}

//	private void start() throws IOException, InterruptedException {
//
//		//write print out at start of important method to test and check 
//		System.out.println("Starting grpc server");
//		
//		//create grpc server and specify port 
//		int port = 50051;
//		server = ServerBuilder.forPort(port)
//				.addService(new AGVServer())
//				.build()
//				.start(); //builder to determine port and add specific service declared in .proto
//		
//		System.out.println("Server running on port: " + port);
//		
//		//awaitTermination
//		server.awaitTermination();
//
//	}

	//Bi-Directional
	@Override
	public StreamObserver<VehicleTrackingRequest> vehicleTracking(
			StreamObserver<VehicleTrackingResponse> responseObserver) {

		return new StreamObserver<VehicleTrackingRequest>(){

			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

			 
			@Override
			public void onNext(VehicleTrackingRequest value) {
				 Date date = new Date(); 
				 
				 String type = value.getAGVtype();
				 
				 System.out.println("Vehicle tracking request for " + type + " AGV.");
				 
				 VehicleTrackingResponse response = VehicleTrackingResponse.newBuilder()
						 .setAGVtype(type)
						 .setAGVlocation(8562495)
						 .build();
				 
				 responseObserver.onNext(response);
				 
				
			}

			@Override
			public void onError(Throwable t) {

				t.printStackTrace();
			}

			@Override
			public void onCompleted() {

				System.out.println("Finished Bi-Directional!");
				responseObserver.onCompleted();
			
			}
			
		
		};
	}

	//Unary
	@Override
	public void agvProductivity(AGVProductivityRequest request,
			StreamObserver<AGVProductivityResponse> responseObserver) {
		int counter = 1;
		//receiving report request
		System.out.println("Report message: " + request.getAGVreport());

		//build response
		
		AGVProductivityResponse response = AGVProductivityResponse.newBuilder()
				.setAGVreportReply("Report " + counter + " for AGV is as follows: ")
				.build();
		
		//send response message
		responseObserver.onNext(response);
		
		//completed
		responseObserver.onCompleted();
		
		
	}

	//Server streaming
	@Override
	public void agvDiag(AGVDiagRequest request, StreamObserver<AGVDiagResponse> responseObserver) {

		System.out.println("Recieving request message from Client: " + request.getAGVdiagRequest());
		
		int requestAmount = request.getAGVfrequency();
		int counter = 1;
		Random rand = new Random();
		
		for(int i = 0; i <= requestAmount; i++) {
			
			int random = rand.nextInt(60-100);
			
			System.out.println("Request " + counter + " process. All systems stable. AGV diagnosis online. System at " + random + "% capacity.");
			counter++;
			
			AGVDiagResponse response = AGVDiagResponse.newBuilder()
					.setAGVdiagType("Vehicle Diasgnostics")
					.setSystemPerformance(random)
					.build();
			
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
	            
	            String service_type = "_AGVSystem._tcp.local.";//"_http._tcp.local.";
	            String service_name = "AGV System Server";// "example";
	            int service_port = 50051;
	            //int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description = "AGV System Service : Server ";//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
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
