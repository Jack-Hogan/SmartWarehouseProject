package ds.smartwarehouse.project.warehouseManagement;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentBlockingStub;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WarehouseManagementClient {

	private static WarehouseManagmentBlockingStub blockingStub;
	private static WarehouseManagmentStub asyncStub;
	
	
	private ServiceInfo WMinfo;

	public static void main(String[] args) {

		WarehouseManagementClient WMClient = new WarehouseManagementClient();
		
		// Discover the jmDNS service
		//String service_type = "_AGVSystem._tcp.local.";
		String service_type = "_http._tcp.local.";
		WMClient.discoverAGV(service_type);
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		// Create stubs (generate from proto)
		blockingStub = WarehouseManagmentGrpc.newBlockingStub(channel);
		asyncStub = WarehouseManagmentGrpc.newStub(channel);
		
//		vehicleTracking();
//		
//		agvProductivity();
//		
//		agvDiag();
		
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
}
