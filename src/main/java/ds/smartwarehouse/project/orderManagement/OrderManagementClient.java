package ds.smartwarehouse.project.orderManagement;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementBlockingStub;
import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementStub;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagementClient;
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

public class OrderManagementClient {
	
	private static final Logger logger = Logger.getLogger(OrderManagementClient.class.getName());

	
	private static OrderManagementBlockingStub blockingStub;
	private static OrderManagementStub asyncStub;
	
	static class OrderManagementInterceptor implements ClientInterceptor{
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
		
		// Create stubs (generated from proto file)
		blockingStub = OrderManagementGrpc.newBlockingStub(channel);
		asyncStub = OrderManagementGrpc.newStub(channel);
		
		
		stockCheck();
		
//		replenishStock();
//		
//		orderTracking();
		
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
					System.out.println("Order Management Service resolved: " + event.getInfo());

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
		StockResponse response;
		
		// Send the message via the blocking stub and store the response
		//Deadline Exception Implementation 
		try {
		 response = blockingStub.withDeadlineAfter(2,TimeUnit.SECONDS).stockCheck(request);
		}catch(StatusRuntimeException e) {
	         logger.log(Level.WARNING, "RPC failed: {0}",e.getStatus());
	         return;
		}
		
		if(response.getStockNumber() <= 0) {
			System.out.println("Error in file: " + response.getNotFoundMsg());
		}
		else {
			// Display the result
			System.out.println("Stock check complete. Item Requested: " + response.getStockType() + ". Current Stock Number: " + response.getStockNumber() +"\n");
			}
			System.out.println("Would you like to check another item? Enter yes to check again\n");
			answer = input.nextLine();
			}
		while(answer.equalsIgnoreCase("yes"));
	}
	
	//Server streaming
	public static void replenishStock () {
		Scanner input = new Scanner(System.in);

		System.out.println("Replenish Stock Called!");
		
		StockReplenishRequest request = StockReplenishRequest.newBuilder()
				.setReplenishMessage("Full stock replenish requested.")
				.build();
		
		StreamObserver<StockReplenishResponse> responseObserver = new StreamObserver<StockReplenishResponse>() {

			@Override
			public void onNext(StockReplenishResponse value) {

				// Display received number
				System.out.println("Item: " + value.getReplenishType());
				System.out.println("Highest Order per month: " + value.getLowStock());
				System.out.println("Current Stock: " + value.getHighStock());
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
		// Display a message to show what method has been called
				System.out.println("orderTracking() has been called:");

				StreamObserver<OrderTrackingResponse> responseObserver = new StreamObserver<OrderTrackingResponse>() {

					@Override
					public void onNext(OrderTrackingResponse value) {

						// Receive Order Number returned from server
						int orderNum = value.getOrderNumber();
						
						String orderStatus = value.getOrderStatus();
						
						// Display sum
						System.out.println("Order Number is: " + orderNum + ". Order Status: " + orderStatus);
								
						try {
							Thread.sleep(2000);
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

						// Stream is completed
						System.out.println("orderTracking() client-streaming has finished\n\n");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}

				
				};
					
					// Send the client data here
					StreamObserver<OrderTrackingRequest> requestObserver = asyncStub.orderTracking(responseObserver);
					
					try {
						Scanner input = new Scanner(System.in);
						
						System.out.println("Can you please enter your order number?");
						int orderNum = input.nextInt();
						int orderCheck= 8;
						
						System.out.println("Order number:"+orderNum+" sent to server. Server will send back update when status has changed.");

						for(int i = 0; i <= orderCheck; i++) {
						OrderTrackingRequest request = OrderTrackingRequest.newBuilder()
								.setOrderNumber(orderNum)
								.build();
						
						requestObserver.onNext(request);
						Thread.sleep(2000);
						}
						
//						request = OrderTrackingRequest.newBuilder()
//								.setOrderNumber(orderNum)
//								.build();
//						
//						requestObserver.onNext(request);
//						Thread.sleep(2000);
//						
//						request = OrderTrackingRequest.newBuilder()
//								.setOrderNumber(orderNum)
//								.build();
//						
//						requestObserver.onNext(request);
//						Thread.sleep(3000);
//						
						// The requests have ended
						requestObserver.onCompleted();
						
						//closing Scanner
						input.close();
						
						// Wait for 3 seconds
						Thread.sleep(3000);
				
					}
					  catch (RuntimeException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {			
						e.printStackTrace();
					}
					
			
	}

}
