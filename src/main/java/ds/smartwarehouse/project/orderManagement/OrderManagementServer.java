package ds.smartwarehouse.project.orderManagement;

import java.io.IOException;

import ds.smartwarehouse.project.orderManagement.OrderManagementGrpc.OrderManagementImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class OrderManagementServer {

	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		//create an object of class
		OrderManagementServer omServer = new OrderManagementServer();
		omServer.start();
		
	}

	private void start() throws IOException, InterruptedException {
		
		System.out.println("Starting grpc server");
		
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new OrderManagementServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();

		
	}
	
	static class OrderManagementServerImpl extends OrderManagementImplBase {
		
		@Override
		public void stockCheck(StockRequest request, StreamObserver<StockResponse> responseObserver) {
			
			//Find out what was sent by the client 
			String stockMessage = request.getStockMessage();
			System.out.println("StockMessage is: " + stockMessage);
			
			//now build response
			//1) Create a builder
			StockResponse.Builder responseBuilder = StockResponse.newBuilder();
			
			responseBuilder.setStockType("Gardening Tools");
			responseBuilder.setStockNumber(42);
			
			responseObserver.onNext(responseBuilder.build());

			
			
		}
	}

}
