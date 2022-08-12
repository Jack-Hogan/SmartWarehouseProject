package ds.smartwarehouse.project.warehouseManagement;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.smartwarehouse.project.AGVSystem.AGVServer;
import ds.smartwarehouse.project.warehouseManagement.WarehouseManagmentGrpc.WarehouseManagmentImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;


public class WarehouseManagementServer extends WarehouseManagmentImplBase {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create object of the Server class
		WarehouseManagementServer WMserver = new WarehouseManagementServer();
				
		WMserver.registerService();

			
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(WMserver)
				.build()
				.start();
		
		System.out.println("New AGV server started listening on port: " + port +"\n");
		
		server.awaitTermination();

	}
	
	private  void registerService() {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_http._tcp.local.";//"_http._tcp.local.";
	            String service_name = "Warehouse Managment Server";// "example";
	            int service_port = 50051;
	            //int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description = "Smart Warehouse Managment Service: Server ";//"path=index.html";
	            
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
}
