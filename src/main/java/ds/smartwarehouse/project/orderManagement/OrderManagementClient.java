package ds.smartwarehouse.project.orderManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementBlockingStub;
import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class OrderManagementClient {
	private static OrderManagementBlockingStub blockingStub;
	private static OrderManagementStub asyncStub;
	
	
	private ServiceInfo OMserverInfo;

	public static void main(String[] args) {

		OrderManagementClient OMclient = new OrderManagementClient();
		
		// Discover the jmDNS service
		//String service_type = "_AGVSystem._tcp.local.";
		String service_type = "_http._tcp.local.";
		OMclient.discoverAGV(service_type);
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		// Create stubs (generate from proto)
		blockingStub = OrderManagementGrpc.newBlockingStub(channel);
		asyncStub = OrderManagementGrpc.newStub(channel);
		
		//Gets here
		//crashes when method called 
		
		stockCheck();
		
		replenishStock();
//		
//		orderTracking();
		
		System.out.println("Client Shutting Down.");
//		
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

					OMserverInfo = event.getInfo();

					int port = OMserverInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + OMserverInfo.getNiceTextString());
					System.out.println("\t host: " + OMserverInfo.getHostAddresses()[0]);
				
					
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
	
	//Unary
	public static void stockCheck () {
		
		Scanner input = new Scanner(System.in);
		String answer = "";
		
		System.out.println("Stock Check Unary Called!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		do {
		//user input to enter item for stock checking
		System.out.println("What item would you like to check stock for?");
		String item = input.nextLine();
		
		StockRequest request = StockRequest.newBuilder()
				.setStockMessage(item)
				.build();
		
		// Send the message via the blocking stub and store the response
		StockResponse response = blockingStub.stockCheck(request);

		// Display the result
		System.out.println("Report is as follows: " + response.getStockType() + ". Stock number: " + response.getStockNumber() +"\n\n");
		System.out.println("Would you like to check another item? Enter yes to check again");
		answer = input.nextLine();
		}
		while(answer.equalsIgnoreCase("yes"));
	}
	
	//Server streaming
	public static void replenishStock () {
		Scanner input = new Scanner(System.in);

		System.out.println("Replenish Stock Called!");
		
		StockReplenishRequest request = StockReplenishRequest.newBuilder()
				.setReplenishMessage("Full stock replensish requested.")
				.build();
		
		StreamObserver<StockReplenishResponse> responseObserver = new StreamObserver<StockReplenishResponse>() {

			@Override
			public void onNext(StockReplenishResponse value) {

				// Display received number
				System.out.println("Item: " + value.getReplenishType());
				System.out.println("Highest Demand: " + value.getLowStock());
				System.out.println("Stock: " + value.getHighStock());
				System.out.println("Stock Replenished: " + value.getStockReplenished() + "\n");
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {

				// Server-streaming is completed
				System.out.println("replenishStock() server-streaming has finished\n\n");
			}
			
		};
		
		// Client sends the request here via the asynchronous stub
		asyncStub.replenishStock(request, responseObserver);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	//Client streaming
	public static void orderTracking() {
		
	}

}
