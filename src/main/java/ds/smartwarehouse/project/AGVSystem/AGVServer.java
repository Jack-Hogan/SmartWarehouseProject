package ds.smartwarehouse.project.AGVSystem;

import java.io.IOException;

import ds.smartwarehouse.project.AGVSystem.AGVSystemGrpc.AGVSystemImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AGVServer extends AGVSystemImplBase {
	
	//import Server class
	private Server server;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//create object of the Server class
		AGVServer ourServer = new AGVServer();
		ourServer.start();

	}

	private void start() throws IOException, InterruptedException {

		//write print out at start of important method to test and check 
		System.out.println("Starting grpc server");
		
		//create grpc server and specify port 
		int port = 50051;
		server = ServerBuilder.forPort(port)
				.addService(new AGVServer())
				.build()
				.start(); //builder to determine port and add specific service declared in .proto
		
		System.out.println("Server running on port: " + port);
		
		//awaitTermination
		server.awaitTermination();

	}
	
	//Extend abstract base class for our own implementation 
	
	static class AGVServerImpl extends AGVSystemImplBase{
		
		
		//body of method declared in .proto file 
		@Override //checking parent class for any issues with method signatures 
		public void getFirstString(containsString request, StreamObserver<containsString> responseObserver ) {
			
			//find out what was sent by the client
			String firstString = request.getFirstString();
			System.out.println("FirstString is: " + firstString);
			
			//now build our response 
			//1) create a builder
			containsString.Builder responseBuilder = containsString.newBuilder();
			
			responseBuilder.setFirstString("We are now responding to the text " + firstString);
			
			responseObserver.onNext(responseBuilder.build()); 
			
			responseObserver.onCompleted();

			
		}
	}

}
