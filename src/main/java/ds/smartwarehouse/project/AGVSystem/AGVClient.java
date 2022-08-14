package ds.smartwarehouse.project.AGVSystem;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import ds.smartwarehouse.project.orderManagement.OrderManagementClient;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.StatusRuntimeException;
import io.grpc.ClientCall.Listener;
import io.grpc.stub.StreamObserver;

public class AGVClient {
	
	private static final Logger logger = Logger.getLogger(AGVClient.class.getName());

	
	private static AGVSystemBlockingStub blockingStub;
	private static AGVSystemStub asyncStub;
	
	static class AGVClientInterceptor implements ClientInterceptor{
		   @Override
		   public <ReqT, RespT> ClientCall<ReqT, RespT>
		   interceptCall(
				   MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
		      return new 
		      ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
		         @Override
		         public void start(Listener<RespT>responseListener, Metadata headers) {
		            logger.info("Added metadata");
		            headers.put(Metadata.Key.of("_http._tcp.local.", ASCII_STRING_MARSHALLER), "MY_HOST");
		            super.start(responseListener, headers);
		         }
		      };
		   }

		}
	
	
	private ServiceInfo AGVInfo;

	public static void main(String[] args) {

		AGVClient AGVclient = new AGVClient();
		
		// Discover the jmDNS service
		//String service_type = "_AGVSystem._tcp.local.";
		String service_type = "_http._tcp.local.";
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
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Client Shutting Down.");

		
		try {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	public static String AGVarray() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Automated Guided Carts");
		list.add("Heavy Burden Carriers");
		list.add("Autonomous Mobile Robots");
		list.add("Vision Guided Tow Tractor");
		list.add("Lazor Guided Conveyor");
		
		String RandomAGV;
		Random rand = new Random();
		int index = rand.nextInt(list.size()-1);
		
		RandomAGV = list.get(index);
		return RandomAGV;
		
		//for ()
		
	}

	// *** BIDIRECTIONAL RPC ***
	public static void vehicleTracking() {
		Random rand = new Random();
//		AGVClient test = new AGVClient();
//		test.AGVarray();
		
		// Display a message to show what method has been called
		System.out.println("Vehicle Tracking() has been called:");
		
		StreamObserver<VehicleTrackingResponse> responseObserver = new StreamObserver<VehicleTrackingResponse>() {

			@Override
			public void onNext(VehicleTrackingResponse value) {

				int agvSerial = rand.nextInt(400);
 
				// Display received number
				System.out.println(value.getAGVtype() + " no." + agvSerial +" Location Locked on at : Latitude: "+ value.getAGVlatitude() +" Longitude: " + value.getAGVlongitude() +"\n");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();	
			}

			@Override
			public void onCompleted() {

				// Bidirectional-streaming is completed
				System.out.println("Bidirectional Vehicle Tracking streaming has finished.\n");	
			}
			
		};
		
		// Client sends the requests here via the asynchronous stub
		StreamObserver<VehicleTrackingRequest> requestObserver = asyncStub.vehicleTracking(responseObserver);
		
		try {
			
			//Sending 1st			
			VehicleTrackingRequest request = VehicleTrackingRequest.newBuilder()
					.setAGVtype(AGVarray())
					.build();
			
			requestObserver.onNext(request);
			
			 //2nd
			request = VehicleTrackingRequest.newBuilder()
				.setAGVtype(AGVarray())
				.build();
			
			requestObserver.onNext(request);
			
			//3rd
			request = VehicleTrackingRequest.newBuilder()
					.setAGVtype(AGVarray())
					.build();
			requestObserver.onNext(request);			
			
			//4th
			request = VehicleTrackingRequest.newBuilder()
					.setAGVtype(AGVarray())
					.build();
			requestObserver.onNext(request);			
			
			//5th
			request = VehicleTrackingRequest.newBuilder()
					.setAGVtype(AGVarray())
					.build();
			requestObserver.onNext(request);
			
			// End the requests
			requestObserver.onCompleted();
			
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
		
		System.out.println("AGV Productivity Unary Called!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//array of vehicles to go here 
		
		AGVProductivityRequest request = AGVProductivityRequest.newBuilder()
				.setAGVreport("Full AGV Productivity Report for Smartwarehouse")//put vehicle inside request
				.build();
		
		// Send the message via the blocking stub and store the response
		AGVProductivityResponse response;
		try {
			response = blockingStub.withDeadlineAfter(3, TimeUnit.SECONDS).agvProductivity(request);
		}
		catch(StatusRuntimeException e) {
	         logger.log(Level.WARNING, "RPC failed: {0}",e.getStatus());
	         return;
		}
		// Display the result
		System.out.println("Report is as follows: " 
				+response.getAGVreportReply() + "\n"
				+response.getPerformance() + "\n"
				+response.getStock() + "\n"
				+response.getMaintenance() + "\n");
		System.out.println("Productivity Report Unary call has finished.\n");
		
	}
	
	//Server Streaming
	public static void agvDiag() {
		Scanner input = new Scanner(System.in);
		int freq;

		System.out.println("AGV Diagnosis Called!");
		System.out.println("How many Vehicles would you like to check diagnostics for? ");

		 freq = input.nextInt();

		AGVDiagRequest request = AGVDiagRequest.newBuilder()
				.setAGVdiagRequest("Full diagnosis required")
				.setAGVfrequency(freq)
				.build();
		
		StreamObserver<AGVDiagResponse> responseObserver = new StreamObserver<AGVDiagResponse>() {

			@Override
			public void onNext(AGVDiagResponse value) {

				// Display received number
				System.out.println("Diagnosis: " + value.getAGVdiagType());
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
