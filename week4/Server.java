import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class Server extends ImplExample {
	public Server() {}
	public static void main(String args[]) {
		try {
			
			ImplExample obj = new ImplExample();
			hello stub = (hello) UnicastRemoteObject.exportObject(obj,0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("hello",stub);
			System.err.println("Server Is Ready!");
		}catch(Exception e)
		{
			System.err.println("Server Exception" + e.toString());
			e.printStackTrace();
		}
		
	}
}
	
