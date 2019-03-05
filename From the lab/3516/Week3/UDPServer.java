import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer
{
	static String names[] = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};  
	public static void main(String args[]) throws IOException, SocketException
	{
		int port = 4545;
		DatagramSocket ds = new DatagramSocket(port);
		System.out.println("Listening to port: " + port);
		while(true)
		{
		byte[] recvBytes = new byte[1024];
		DatagramPacket dpReceive = new DatagramPacket(recvBytes,recvBytes.length);
		ds.receive(dpReceive);
		String receivedMesssage = new String(dpReceive.getData()).trim();
		System.out.println("Message from the Client: " + receivedMesssage);
		if(receivedMesssage.equals("bye"))
			break;
		try{
			String sendMessage;
			int index = Integer.parseInt(receivedMesssage.trim())-1;
			if(index<0 || index >=names.length)
			{
				sendMessage = new String("Invalid Input!");
			}
			else{
				sendMessage = new String(names[index]);
			}
			
			byte[] sendBytes = sendMessage.getBytes();
		DatagramPacket dpSend = new DatagramPacket(sendBytes, sendBytes.length,dpReceive.getAddress(),dpReceive.getPort());
		ds.send(dpSend);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
		System.out.println("Closed");
		ds.close();
	}
}