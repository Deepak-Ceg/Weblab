import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
 
public class HotelClient2 { 
 
   private HotelClient2() {} 
 
   public static void main(String[] args) { 
 
      try { 
 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         RoomManager stub = (RoomManager) registry.lookup("HotelRooms"); 
    
	
         stub.printMsg();
		 
		
		if(args.length == 0)
		{
			System.out.println("Enter  list <port> to get available rooms and its price \n Enter book <port> <roomtype> <guest name> to book the hotel \n Enter guests <port> to list the available guests");
		}
		else if(args[0].equals("List") && args[1].equals("6000"))
		{
		
		 String output = stub.Lists();
		 System.out.println(output);
			
			
		}
		
		else if(args[0].equals("Book"))
		{
			int index = Integer.parseInt(args[2]);
			String ans = new String(stub.Book(index, args[3]));
			System.out.println(ans);
			
				
			
		}
		else if(args[0].equals("Guests"))
		{
				String ans = new String(stub.Guests());
				System.out.println(ans);
		}
		 
		 
		 
     } catch (Exception e) { 
          
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
        } 
    } 
}