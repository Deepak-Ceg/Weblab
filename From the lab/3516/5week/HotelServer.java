import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
         
public class HotelServer extends RoomManagerImpl{ 
         
   public HotelServer() {} 
   public static void main(String args[]) { 
         
      try { 
       
   
         RoomManagerImpl obj = new RoomManagerImpl(); 
     
         RoomManager stub = (RoomManager) UnicastRemoteObject.exportObject(obj, 0); 
 
         // Binding the remote object (stub) in the registry 
         Registry registry = LocateRegistry.getRegistry(); 
         registry.rebind("HotelRooms", stub); 
	     System.err.println("Server ready"); 
       
         } catch (Exception e) { 
             
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
        } 
    } 
}