import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.io.*;
import java.util.*;
public class Client extends ImplExample
{
	public Client(){ }
	public static void main(String args[]){
		
		try{
		Scanner sc = new Scanner(System.in);
		Registry registry = LocateRegistry.getRegistry(null);
		hello stub = (hello) registry.lookup("hello");
		String x;
		x = sc.nextLine();
		stub.printMsg();
	}catch(Exception e){
		System.err.println("Client Exception: "+ e.toString());
		e.printStackTrace();
	}
	}
}