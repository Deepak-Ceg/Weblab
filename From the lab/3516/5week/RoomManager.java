import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface RoomManager extends Remote {  
   
   public String Lists() throws RemoteException;
   public String Book(int i,String guestname) throws RemoteException;
   public String Guests() throws RemoteException;
   void printMsg() throws RemoteException;  

   }