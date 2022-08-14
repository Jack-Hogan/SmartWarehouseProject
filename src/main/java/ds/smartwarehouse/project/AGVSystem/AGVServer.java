package ds.smartwarehouse.project.AGVSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse.Builder;
import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc.AGVSystemImplBase;
import ds.smartwarehouse.project.orderManagement.OrderManagementServer;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerCall.Listener;
import io.grpc.stub.StreamObserver;

public class AGVServer extends AGVSystemImplBase {
	
	private static final Logger logger = Logger.getLogger(AGVServer.class.getName());

	/*Metadata reading client*/
	class AGVInterceptor implements ServerInterceptor{
	      @Override
	      public <ReqT, RespT> Listener<ReqT> 
	      interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
	 
	         logger.info("Recieved following metadata: " + headers);
	         return next.startCall(call, headers);
	      }

	   }


	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of the Server class
		AGVServer serverAGV = new AGVServer();
		
		serverAGV.registerService();

		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(serverAGV)
				.build()
				.start();
		
		System.out.println("New AGV server started listening on port: " + port +"\n");
		
		server.awaitTermination();
		

	}

	
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

	//Bi-Directional
	@Override
	public StreamObserver<VehicleTrackingRequest> vehicleTracking(
			StreamObserver<VehicleTrackingResponse> responseObserver) {

		return new StreamObserver<VehicleTrackingRequest>(){
		 
			@Override
			public void onNext(VehicleTrackingRequest value) {
				 Date date = new Date(); 
				 
				 String type = value.getAGVtype();
				 
				 System.out.println("Vehicle tracking request for " + type + " AGV at: " + date + "\n");
				 
				    double minLat = -90.00;
				    double maxLat = 90.00;      
				    double latitude = minLat + (double)(Math.random() * ((maxLat - minLat) + 1));
				    double minLon = 0.00;
				    double maxLon = 180.00;     
				    double longitude = minLon + (double)(Math.random() * ((maxLon - minLon) + 1));
				 
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

				System.out.println("Finished Bi-Directional vehicle tracking service.\n");
				responseObserver.onCompleted();
			
			}
			
		
		};
	}

	//Unary
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

	//Server streaming
	@Override
	public void agvDiag(AGVDiagRequest request, StreamObserver<AGVDiagResponse> responseObserver) {

		
		int requestAmount = request.getAGVfrequency();
		int counter = 1;
		Random rand = new Random();
		AGVServer agv = new AGVServer();
		
		System.out.println("\nReceiving request message from Client: " + request.getAGVdiagRequest() + " for " +requestAmount +" vehicles. Request Recieved Successfully");

		
		for(int i = 0; i < requestAmount; i++) {
			
			int random = rand.nextInt(((100 - 60)+1)+60);
			String AGV = agv.AGVarray();
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
			//System.out.println("Requesting Diagnois Test:" + counter + ".Sending AGV diagnosis for " + AGV + ". Testing capacity status. Streaming messges to client...");
			
			
			AGVDiagResponse response = AGVDiagResponse.newBuilder()
					//.setAGVdiagType(AGV + " Vehicle Diagnostics Incoming")
					.setAGVdiagType("Request " + counter + " process. AGV diagnosis online. " + AGV + " System at " + random + "% capacity. Status: " + status)
					.setSystemPerformance(random)
					.build();
			counter++;
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
