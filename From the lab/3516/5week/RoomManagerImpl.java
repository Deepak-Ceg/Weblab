import java.util.*;

public class RoomManagerImpl implements RoomManager
{  
  
	static String[] names;
	static int[] costs;
	static int[] roomcount;
	ArrayList<String> GuestDetails;
  public RoomManagerImpl()
  {
		GuestDetails = new ArrayList<String>();
	    names = new String[5];
		costs = new int[5];
		roomcount = new int[5];
		names[0] = "Single Room";
		costs[0] = 55;
		roomcount[0] = 10;
		names[1] = new String("Double Room");
		costs[1] = 75;
		roomcount[1] = 20;
		names[2] = new String("Twin Room");
		costs[2] = 80;
		roomcount[2] = 5;
		names[3] = new String("Triple Room");
		costs[3] = 150;
		roomcount[3] = 3;
		names[4] = new String("Quad Room");
		costs[4] = 230;
		roomcount[4] = 2;
		
   }
  
	public String Lists()
	{
		String output;
		output = new String( roomcount[0] + " rooms of type 0 are available for " + costs[0] + " Euros per night\n" + roomcount[1] + " rooms of type 1 are available for " + costs[1] + " Euros per night\n" + roomcount[2] + " rooms of type 2 are available for " + costs[2] + " Euros per night\n" + roomcount[3] + " rooms of type 3 are available for " + costs[3] + " Euros per night\n" + roomcount[4] + " rooms of type 4 are available for " + costs[4] + " Euros per night\n");
		return output;
	}
	
	public String Book(int i, String guestname)
	{
		if(roomcount[i]<=0)
			return new String("Room is Full! Try Someother Type of Rooms");
		String guest = new String(guestname + " Occupied " + names[i]);
		roomcount[i]--;
		GuestDetails.add(guest);
	return new String("Hello " + guestname +"! \nYour " + names[i] + " is Booked\nKindly pay " + costs[i]); 
	}
		
	public String Guests() {  
      String result = new String();
	for(String G : GuestDetails)
		result += G + '\n';
	
	return result;
   }	
   
			
	
   public void printMsg() {  
      System.out.println("Hello This is Deepak From CEG");  
   
   }

	
   
}