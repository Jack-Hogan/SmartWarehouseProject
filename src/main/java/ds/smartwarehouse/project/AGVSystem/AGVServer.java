package ds.smartwarehouse.project.AGVSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.util.ArrayList;
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
	
	public String AGVarray() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Automated Guided Carts");
		list.add("Heavy Burden Carriers");
		list.add("Autonomous Mobile Robots");
		list.add("Vision Guided Tow Tractor");
		list.add("Lazor Guided Conveyor");
		
		String RandomAGV;
		Random rand = new Random();
		int index = rand.nextInt((4) + 1);
		
		RandomAGV = list.get(index);
		return RandomAGV;
		

		
	}

	//Bi-Directional
	@Override
	public StreamObserver<VehicleTrackingRequest> vehicleTracking(
			StreamObserver<VehicleTrackingResponse> responseObserver) {

		return new StreamObserver<VehicleTrackingRequest>(){

			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

			 
			@Override
			public void onNext(VehicleTrackingRequest value) {
				 Date date = new Date(); 
				 Random rand = new Random();

				 
				 String type = value.getAGVtype();
				 
				 System.out.println("Vehicle tracking request for " + type + " AGV at: " + date);
				 
				 VehicleTrackingResponse response = VehicleTrackingResponse.newBuilder()
						 .setAGVtype(type)
						 .setAGVlocation(rand.nextInt())
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
		Random rand = new Random();
		
		
		int id = rand.nextInt((1000-500)+1);
		boolean perform = rand.nextBoolean();
		String AGV = AGVarray();
		//receiving report request
		System.out.println("Request Message: " + request.getAGVreport());

		//build response
		
		AGVProductivityResponse response = AGVProductivityResponse.newBuilder()
				.setAGVreportReply("Report " + id + " for AGV is as follows: "
						+ "Performance Over 85%: " + perform + ".\n Most Effcient AGV: "+AGV)//" + counter + "
				.build();
		
		//send response message
		responseObserver.onNext(response);
		
		//completed
		responseObserver.onCompleted();
		
		
	}

	//Server streaming
	@Override
	public void agvDiag(AGVDiagRequest request, StreamObserver<AGVDiagResponse> responseObserver) {

		System.out.println("Receiving request message from Client: " + request.getAGVdiagRequest());
		
		int requestAmount = request.getAGVfrequency();
		int counter = 1;
		Random rand = new Random();
		AGVServer agv = new AGVServer();
		
		for(int i = 0; i < requestAmount; i++) {
			
			int random = rand.nextInt(((100 - 60)+1)+60);
			String AGV = agv.AGVarray();
			String status = "";
			if(random<20) {
				status = "Critical!";
			}
			else if(random <40) {
				status = "Warning!";
			}
			else if(random <60) {
				status = "Okay";
			}
			else {
				status = "Optimal";
			}
			System.out.println("Request " + counter + " process. AGV diagnosis online. " + AGV + " System at " + random + "% capacity. Status: " + status);
			counter++;
			
			AGVDiagResponse response = AGVDiagResponse.newBuilder()
					.setAGVdiagType(AGV + " Vehicle Diagnostics Incoming")
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
