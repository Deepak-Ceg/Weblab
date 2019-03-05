import java.io.*;
import java.net.*;
import java.util.*;

public class UDPDictClient
{
	
	public static void main(String args[]) throws IOException, SocketException, UnknownHostException	
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 4545;
		DatagramSocket ds = new DatagramSocket();
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Enter the word to search: ");
			String inp = input.nextLine();
			try
			{
				byte[] sendBytes = inp.getBytes();
				DatagramPacket dpSend = new DatagramPacket(sendBytes, sendBytes.length,ip,port);
				ds.send(dpSend);
				if(inp.equals("bye")){
					break;
				}
				
				byte[] recvBytes = new byte[1024];
				DatagramPacket dpReceive = new DatagramPacket(recvBytes,recvBytes.length);
				ds.receive(dpReceive);
				String receiveMessage = new String(dpReceive.getData());   //receiving data
				System.out.println("Message from the Server: " + receiveMessage);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Closing....Bye!");
		input.close();
		ds.close();
	}
}