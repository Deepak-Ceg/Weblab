import java.io.*;
import java.net.*;
import java.util.*;

public class PortScanner
{
	public static void main(String[] args) throws IOException, SocketException
	{
		Scanner input = new Scanner(System.in);
		InetAddress ip = InetAddress.getLocalHost();
		int startp,endp;
		System.out.println("Enter Start Port number: ");
		startp = input.nextInt();
		System.out.println("Enter End Port Number: ");
		endp = input.nextInt();
		System.out.println("Scanning....");
		ArrayList<Integer> openPorts = new ArrayList<Integer>();
		ArrayList<Integer> closedPorts = new ArrayList<Integer>();
		for( int port=startp; port<endp; port++)
		{
			try
			{
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress(ip,port), 10);
				openPorts.add(port);
				socket.close();
			}catch(Exception e){
				closedPorts.add(port);
			}
		}
		
		System.out.println("No of Open Ports: " + openPorts.size());
		
		System.out.println("No of Closed Ports: " + closedPorts.size());
		
		System.out.println("Open Ports are: ");
		for(Integer port : openPorts){
			
			System.out.println("Listening on: " + port);
		}
		input.close();
	}
}