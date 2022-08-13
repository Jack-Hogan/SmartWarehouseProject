package ds.smartwarehouse.project.orderManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class OrderManagementServer extends OrderManagementImplBase{

	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of the Server class
		OrderManagementServer orderServer = new OrderManagementServer();
		
		orderServer.registerService();

		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(orderServer)
				.build()
				.start();
		
		System.out.println("New Order Management server started listening on port: " + port +"\n");
		
		server.awaitTermination();
	
	}
	
	private  void registerService() {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_http._tcp.local.";//"_http._tcp.local.";
	            String service_name = "Order Management Server";// "example";
	            int service_port = 50051;
	            //int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description = "Order Management : Server ";//"path=index.html";
	            
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
	
	public ArrayList<String> array() {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Laptops");
		list.add("Monitors");
		list.add("Cables");
		list.add("Speakers");
		list.add("TVs");
		list.add("Washing Machines");
		list.add("Fridges");
		list.add("Wearables");
		list.add("Smartphones");
		
		return list;
	}
	
	public String stockType() {
		
		
		Random rand = new Random();
		int index = rand.nextInt(8);
		
		return array().get(index);
	}
	
	public int randomNum() {
		Random rand = new Random();

		int num = rand.nextInt(100);
		return num;
	}

	//Unary
	@Override
	public void stockCheck(StockRequest request, StreamObserver<StockResponse> responseObserver) {
		
		//receive request
		
		//String type = stockType();
		
		System.out.println("Request Message from Client: " + request.getStockMessage());
		boolean itemFound = false;

		try {
			StockResponse response;
		for(int i = 0; i <array().size(); i++) {
			
		
			if(array().get(i).equalsIgnoreCase(request.getStockMessage())) {
				itemFound = true;
				response = StockResponse.newBuilder()
						.setStockNumber(randomNum())
						.setStockType(array().get(i))
						.build();
				
				//send response
				responseObserver.onNext(response);
	
				//complete
				responseObserver.onCompleted();
			}
			else {
				System.out.println("Client item does not match stock number:" + i+1 + ".");
			}

		}
		if(itemFound == false) {
//	           Status status = Status.FAILED_PRECONDITION.withDescription("Not between 2 and 20");
//	            responseObserver.onError(status.asRuntimeException());
//	            //return;
			response = StockResponse.newBuilder()
					.setNotFoundMsg("Item not found, please try again!!")
					.build();
			
			//send response
			responseObserver.onNext(response);

			//complete
			responseObserver.onCompleted();
		}
		}
		catch (Exception e){
		    Status status = Status.fromThrowable(e);
		    System.out.println(status.getCode() + " : " + status.getDescription());
		}

		
		//build response
		



	}

	//Server Streaming
	@Override
	public void replenishStock(StockReplenishRequest request, StreamObserver<StockReplenishResponse> responseObserver) {

		Random rand = new Random();
		//receive request
		System.out.println("\nReceiving request message from Client: " + request.getReplenishMessage());
		
		//build response 
		for(int i = 0 ; i <array().size(); i++) {
			
		boolean stockReplen = rand.nextBoolean();

		StockReplenishResponse response = StockReplenishResponse.newBuilder()
				.setLowStock(randomNum())
				.setHighStock(randomNum())
				.setReplenishType(array().get(i))
				.setStockReplenished(stockReplen)
				.build();

			responseObserver.onNext(response);
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}	
			
		responseObserver.onCompleted();
		
	}
	

	//Client Streaming
	@Override
	public StreamObserver<OrderTrackingRequest> orderTracking(StreamObserver<OrderTrackingResponse> responseObserver) {
		
		return new StreamObserver<OrderTrackingRequest>(){


			Date date = new Date();
			
			ArrayList <Integer> list = new ArrayList<>();
			String[] status = new String[]{"Delivered","Undelivered", "Leaving Warehouse", "Out For Delivery","Ready for Collection"};
			Random rand = new Random();
			String delivery = status[rand.nextInt(4)];
			
			int orderNo;

			 
			@Override
			public void onNext(OrderTrackingRequest value) {
				

				 orderNo = value.getOrderNumber();
				 
				 System.out.println("Order tracking request for order: " + value.getOrderNumber() + " "+ date + "\n");
				 
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
				


				System.out.println("List: " + list);
				 OrderTrackingResponse response = OrderTrackingResponse.newBuilder()
						.setOrderNumber(orderNo)
						.setOrderStatus(delivery)
						.build();
				 
					responseObserver.onNext(response);
	 
				System.out.println("Finished Bi-Directional order tracking service.\n");
							
				responseObserver.onCompleted();
			
			}
			
		
		};
	
	}

}
