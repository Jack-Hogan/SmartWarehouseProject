package ds.smartwarehouse.project.warehouseManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import com.google.rpc.Code;
import com.google.rpc.Status;

import ds.smartwarehouse.project.orderManagement.OrderManagementServer;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentBlockingStub;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentStub;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.Metadata;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

import io.grpc.ForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;

public class WarehouseManagementClient {

	//logger for metadata 
	private static final Logger logger = Logger.getLogger(WarehouseManagementClient.class.getName());
	
	private static WarehouseManagmentBlockingStub blockingStub;
	private static WarehouseManagmentStub asyncStub;
	
	//metadata interceptor to catch calls and log host
	static class WarehouseManagementInterceptor implements ClientInterceptor{
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
	
	//private service information variable
	private ServiceInfo WMinfo;

	//main method
	public static void main(String[] args) {

		//create instance of client class
		WarehouseManagementClient WMClient = new WarehouseManagementClient();
		
		// Discover the jmDNS service
		//String service_type = "_AGVSystem._tcp.local.";
		String service_type = "_http._tcp.local.";
		
		//call and invoke jmDNS discover method and pass service_type as parameter
		WMClient.discoverWM(service_type);
		
		//build new channel 
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		// Create stubs (generate from proto)
		blockingStub = WarehouseManagmentGrpc.newBlockingStub(channel);
		asyncStub = WarehouseManagmentGrpc.newStub(channel);
		
		//call rpc invocation 
		productivityReport();
		
		demandForecast();
		
		realTimeOverview();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//client closing 
		System.out.println("Client Shutting Down.");
		
		try {
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//jmDNS discover 
	private void discoverWM(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			//add listener for services specified, call service listener	
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				//service resolved, display server properties 
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Warehouse Management Service resolved: " + event.getInfo());

					WMinfo = event.getInfo();

					int port = WMinfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + WMinfo.getNiceTextString());
					System.out.println("\t host: " + WMinfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Warehouse Management Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Warehouse Management Service added: " + event.getInfo());

					
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

		/*Unary*/
		public static void productivityReport() {
			//call Unary
			System.out.println("Productivity Report Unary Called!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//input for user 
		Scanner input = new Scanner(System.in);
		
		//earnings to pass to server as a single request 
		System.out.println("Please enter earnings for Q1? ");
		double q1 = input.nextDouble();		
		
		System.out.println("And for Q2? ");
		double q2 = input.nextDouble();		
		
		System.out.println("And for Q3? ");
		double q3 = input.nextDouble();		
		
		System.out.println("And for Q4? ");
		double q4 = input.nextDouble();
		
		//build request report 
		ProductivityReportRequest request = ProductivityReportRequest.newBuilder()
				.setProdReport("Full Productivity Overview Report required.\n")
				.setQ1Earning(q1)
				.setQ2Earning(q2)
				.setQ3Earning(q3)
				.setQ4Earning(q4)
				.build();
		ProductivityReportResponse response;
		
		// Send the message via the blocking stub and store the response
		CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
		try {
			response = blockingStub.withOption(metaDataKey, "bar").productivityReport(request);
		}catch (StatusRuntimeException e) {
	         logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
	         return;
		}
		// Display the result from server
		System.out.println("Productivity Overview Report is as follows: " + response.getProdReportService() + "\n\n");
		System.out.println("Employee Count: " + response.getEmployeeCount());
		System.out.println("AGV Performance: " + response.getAGVperformance());
		System.out.println("Q1 Earnings: €" + response.getQ1Earning());
		System.out.println("Q2 Earnings: €" + response.getQ2Earning());
		System.out.println("Q3 Earnings: €" + response.getQ3Earning());
		System.out.println("Q4 Earnings: €" + response.getQ4Earning());
		System.out.println("Quarterly Average: €" + response.getQuartAvg());
		System.out.println("Monthly Average: €" + response.getAnnualAvgEarning());
		System.out.println("Total Earnings: €" + response.getTotalEarning());
		
		System.out.println("Productivity Report Unary call has finished.\n");
		
	}
		
		/*Client Streaming*/
		public static void demandForecast() {
			System.out.println("demandForecast() has been called:");
			
			Random rand = new Random();
			
			//create object of type OrderManagementServer to use array of items in warehouse 
			OrderManagementServer OMServer = new OrderManagementServer();
			String newItem = OMServer.array().get(rand.nextInt(8));
			
			StreamObserver<DemandForecastResponse> responseObserver = new StreamObserver<DemandForecastResponse>() {

				
				@Override
				public void onNext(DemandForecastResponse value) {

					// Receive Order Number returned from server
					int inHighDemand = value.getHighDemand();
					
					//String variable to keep track if item is deemed high demand
					String isItemHighDemand = "";
					
					//if else statments to determine if a product is in high demand or not
					String forecastReview = value.getForecastReview();
					if(inHighDemand >=150) {
						isItemHighDemand = "Product is in High demand, product selling over 150 units per annum. ";
					}
					else if(inHighDemand >=80) {
						isItemHighDemand = "Product is in Medium Demand, product selling over 80 units per annum.";
					}
					else {
						isItemHighDemand = "Product is in Low Demand, product selling less than 80 units per annum.";
					}

					//display result to client 
					System.out.println(newItem+" selling " + inHighDemand + " per annum. " + isItemHighDemand + " for Forecast Review: " + forecastReview);
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();				
				}

				@Override
				public void onCompleted() {

					// Stream is completed
					System.out.println("demandForecast() client-streaming has finished\n\n");
				}
			};
				
				// Send the client data here
				Scanner input = new Scanner(System.in);

				//build stream of client requests 
				StreamObserver<DemandForecastRequest> requestObserver = asyncStub.demandForecast(responseObserver);
				
				try {//determine how many items were sold and send to server 
					//build request
					//1)
					System.out.println("How many " +newItem+ " were sold in Q1? " );
					int items = input.nextInt();

					DemandForecastRequest request = DemandForecastRequest.newBuilder()
							.setItemsSold(items)
							.setForecastMessage(newItem + " forecast")
							.build();
					
					requestObserver.onNext(request);
					Thread.sleep(500);
					
					//)2
					System.out.println("How many " +newItem+ " were sold in Q2? " );
					int items2 = input.nextInt();
					request = DemandForecastRequest.newBuilder()
							.setItemsSold(items2)
							.setForecastMessage(newItem + " forecast")
							.build();
					
					requestObserver.onNext(request);
					Thread.sleep(500);
					
					//3)
					System.out.println("How many " +newItem+ " were sold in Q3? " );
					int items3 = input.nextInt();
					request = DemandForecastRequest.newBuilder()
							.setItemsSold(items3)
							.setForecastMessage(newItem + " forecast")
							.build();
					
					requestObserver.onNext(request);
					Thread.sleep(500);					
					
					//4)
					System.out.println("How many " +newItem+ " were sold in Q4? " );
					int items4 = input.nextInt();
					request = DemandForecastRequest.newBuilder()
							.setItemsSold(items4)
							.setForecastMessage(newItem + " forecast")
							.build();
					
					requestObserver.onNext(request);
					Thread.sleep(1000);
					
					// The requests have ended
					requestObserver.onCompleted();
					
					// Wait for 2 seconds
					Thread.sleep(2000);
			
				}
				  catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
				input.close();

		}
		
		/*Bi-Directional*/
		public static void realTimeOverview() {
			
			System.out.println("realTimeOverview() has been called:");
			//receive stream response 
			StreamObserver<RealTimeOverviewResponse> responseObserver = new StreamObserver<RealTimeOverviewResponse>() {

				@Override
				public void onNext(RealTimeOverviewResponse value) {
	 
					// Display received vehicle and warehouse Overview 
					System.out.println("Realtime Overview: "+value.getVehicleOverview() + value.getWarehouseOverview() +".");
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
					System.out.println("Bidirectional RealTime Overview streaming has finished.\n");	
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
			
			// Client sends the requests here via the asynchronous stub
			StreamObserver<RealTimeOverviewRequest> requestObserver = asyncStub.realTimeOverview(responseObserver);
			try {
				
				// Sending 1st
//				Scanner input = new Scanner(System.in);
//				System.out.println("Please enter your real time request from the following options: 'Employee','AGV Overview','Temperature Control'");
				RealTimeOverviewRequest request = RealTimeOverviewRequest.newBuilder()
						.setOverviewMessage("Employee")
						.build();
				
				requestObserver.onNext(request);
				
				 //2nd
				request = RealTimeOverviewRequest.newBuilder()
						.setOverviewMessage("AGV Overview")
						.build();
				
				requestObserver.onNext(request);
				
				//3rd
				request = RealTimeOverviewRequest.newBuilder()
						.setOverviewMessage("Temperature Control")
						.build();
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
			
		}
	
}
