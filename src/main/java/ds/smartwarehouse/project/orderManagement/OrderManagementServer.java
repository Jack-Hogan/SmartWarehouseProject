package ds.smartwarehouse.project.orderManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementImplBase;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagementServer;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.ServerCall.Listener;
import io.grpc.stub.StreamObserver;

public class OrderManagementServer extends OrderManagementImplBase{

	//logger to log metadata 
	private static final Logger logger = Logger.getLogger(OrderManagementServer.class.getName());
	
	/*Metadata reading client*/
	class OrderManagementInterceptor implements ServerInterceptor{
	      @Override
	      public <ReqT, RespT> Listener<ReqT> 
	      interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
	 
	         logger.info("Recieved following metadata: " + headers);
	         return next.startCall(call, headers);
	      }

	   }

	//main method
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of the Server class
		OrderManagementServer orderServer = new OrderManagementServer();
		
		//call register service on server
		orderServer.registerService();

		//port number
		int port = 50051;
		
		//build server and start
		Server server = ServerBuilder.forPort(port)
				.addService(orderServer)
				.build()
				.start();
		
		System.out.println("New Order Management server started listening on port: " + port +"\n");
		
		server.awaitTermination();
	
	}
	//jmDNS register service
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
	
	//array to choose or display warehouse inventory items
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
	
	//method for random item checking 
	public String stockType() {
		
		Random rand = new Random();
		int index = rand.nextInt(8);
		
		return array().get(index);//return random item from arraylist
	}
	
	//method for random number up to 100
	public int randomNum() {
		Random rand = new Random();

		int num = rand.nextInt(100);
		return num;
	}

	/*Unary*/
	@Override
	public void stockCheck(StockRequest request, StreamObserver<StockResponse> responseObserver) {
		
		//receive request
		
		System.out.println("Request Message from Client: " + request.getStockMessage());
		boolean itemFound = false;

//		/*Deadline Exceeded Example*/
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		try {
			StockResponse response;
		for(int i = 0; i <array().size(); i++) {
			
			//if item sent by client matches item from inventory then build response
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
			else {//server message to display mismatch 
				System.out.println("Client item does not match stock number:" + i + ".");
			}

		}//return error to client if no item matches inventory
		if(itemFound == false) {//error handling 
			response = StockResponse.newBuilder()
					.setNotFoundMsg("Item not found, please try again!")
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


	}

	/*Server Streaming*/
	@Override
	public void replenishStock(StockReplenishRequest request, StreamObserver<StockReplenishResponse> responseObserver) {

		//receive request
		System.out.println("\nReceiving request message from Client: " + request.getReplenishMessage());
		
		//build response 
		//for loop to display stock of all items in inventory for warehouse 
		for(int i = 0 ; i <array().size(); i++) {
			
			//variable to track stock levels and boolean to see if stock needs replenished 
			boolean stockReplen;
			int stockCheck = randomNum();
			
			//if stock is under 40, stock will be replenished
			if(stockCheck <40) {
				stockReplen = true;
			}
			else {
				stockReplen = false;
			}
			//build response to client accordingly 
			StockReplenishResponse response = StockReplenishResponse.newBuilder()
					.setLowStock(randomNum())
					.setHighStock(stockCheck)
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
		//response completed
		responseObserver.onCompleted();
		
	}
	

	/*Client Streaming*/
	@Override
	public StreamObserver<OrderTrackingRequest> orderTracking(StreamObserver<OrderTrackingResponse> responseObserver) {
		
		return new StreamObserver<OrderTrackingRequest>(){

			//date class used to display date 
			Date date = new Date();
			
			//String array to determine status of order tracking
			String[] status = new String[]{"Delivered","Undelivered", "Leaving Warehouse", "Out For Delivery","Ready for Collection"};
			Random rand = new Random();
			//random delivery assigned 
			String delivery = status[rand.nextInt(4)];
			
			int orderNo;

			 
			@Override
			public void onNext(OrderTrackingRequest value) {
				
				//get order number from client 
				 orderNo = value.getOrderNumber();
				 //order number and date stamp
				 System.out.println("Order tracking request for order: " + value.getOrderNumber() + " "+ date + "\n");
				 
				 try {
					Thread.sleep(2500);
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
				
				//build response to client 
				 OrderTrackingResponse response = OrderTrackingResponse.newBuilder()
						.setOrderNumber(orderNo)
						.setOrderStatus(delivery)
						.build();
				 
					responseObserver.onNext(response);
	 
				//finished bi-directional
				System.out.println("Finished Bi-Directional order tracking service.\n");
							
				responseObserver.onCompleted();
			
			}
			
		
		};
	
	}

}
