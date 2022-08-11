package ds.smartwarehouse.project.AGVSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


import ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse;
import ds.smartwarehouse.project.AGVSystem.AGVDiagResponse;
import ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse;
import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc;
import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc.AGVSystemBlockingStub;
import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc.AGVSystemStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class AGVClient {
	
	private static AGVSystemBlockingStub blockingStub;
	private static AGVSystemStub asyncStub;
	
	
	
	private ServiceInfo AGVInfo;

	public static void main(String[] args) {

		AGVClient AGVclient = new AGVClient();
		
		// Discover the jmDNS service
		String service_type = "_AGVSystem._tcp.local.";
		AGVclient.discoverAGV(service_type);
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		// Create stubs (generate from proto)
		blockingStub = AGVSystemGrpc.newBlockingStub(channel);
		asyncStub = AGVSystemGrpc.newStub(channel);
		
		//Gets here
		//crashes when method called 
		
		vehicleTracking();
		
		agvProductivity();
		
		agvDiag();
		
		

	}
	
	private void discoverAGV(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("AGV Service resolved: " + event.getInfo());

					AGVInfo = event.getInfo();

					int port = AGVInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + AGVInfo.getNiceTextString());
					System.out.println("\t host: " + AGVInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("AGV Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("AGV Service added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	// *** BIDIRECTIONAL RPC ***
	public static void vehicleTracking() {
		
		// Display a message to show what method has been called
		System.out.println("total() has been called:");
		
		StreamObserver<VehicleTrackingResponse> responseObserver = new StreamObserver<VehicleTrackingResponse>() {

			@Override
			public void onNext(VehicleTrackingResponse value) {

				// Display received number
				System.out.println(value.getAGVlocation());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();	
			}

			@Override
			public void onCompleted() {

				// Bidirectional-streaming is completed
				System.out.println("total() bidirectional-streaming has finished");	
			}
			
		};
		
		// Client sends the requests here via the asynchronous stub
		StreamObserver<VehicleTrackingRequest> requestObserver = asyncStub.vehicleTracking(responseObserver);
		
		try {
			
			// Style #1
			int num = 50;
			
			VehicleTrackingRequest request = VehicleTrackingRequest.newBuilder()
					.setAGVtype("Automated Guided Carts")
					.build();
			
			requestObserver.onNext(request);
			
			 // Style #2
			request = VehicleTrackingRequest.newBuilder()
				.setAGVtype("Heavy Burden Carriers")
				.build();
			
			requestObserver.onNext(request);
			
			// Style #3
			requestObserver.onNext(VehicleTrackingRequest.newBuilder()
					.setAGVtype("Autonomous Mobile Robots")
					.build());
			requestObserver.onNext(request);
			
			// End the requests
			requestObserver.onCompleted();
			
			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);
			
		} catch (RuntimeException e) { 
			e.printStackTrace(); 
		}  catch (InterruptedException e) { 
			e.printStackTrace(); 
		}


		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//Unary
	public static void agvProductivity() {
		
		System.out.println("AGV Productivity Called!");
		
		//array of vehicles to go here 
		
		AGVProductivityRequest request = AGVProductivityRequest.newBuilder()
				.setAGVreport("Report for stacking vechicles")//put vehicle inside request
				.build();
		
		// Send the message via the blocking stub and store the response
		AGVProductivityResponse response = blockingStub.agvProductivity(request);

		// Display the result
		System.out.println("Report is as follows: " + response.getAGVreportReply() + "\n\n");
		System.out.println("Productivity Report Unary call has finished");
		
	}
	
	//Server Streaming
	public static void agvDiag() {
		
		System.out.println("AGV Diagnosis Called!");
		
		AGVDiagRequest request = AGVDiagRequest.newBuilder()
				.setAGVdiagRequest("Fuel and effciency call")
				.build();
		
		StreamObserver<AGVDiagResponse> responseObserver = new StreamObserver<AGVDiagResponse>() {

			@Override
			public void onNext(AGVDiagResponse value) {

				// Display received number
				System.out.println(value.getAGVdiagType());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {

				// Server-streaming is completed
				System.out.println("AGV Diagnosis() server-streaming has finished\n\n");
			}
			
		};
		
		// Client sends the request here via the asynchronous stub
		asyncStub.agvDiag(request, responseObserver);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
