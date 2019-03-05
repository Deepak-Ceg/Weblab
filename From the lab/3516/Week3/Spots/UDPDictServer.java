import java.io.*;
import java.net.*;
import java.util.*;

public class UDPDictServer
{
	static String names[][] = {{"CSS","Cascading Style Sheets, fondly referred to as CSS, is a simple design language intended to simplify the process of making web pages presentable."},{"JavaScript","Javascript is a dynamic computer programming language. It is lightweight and most commonly used as a part of web pages, whose implementations allow client-side script to interact with the user and make dynamic pages. It is an interpreted programming language with object-oriented capabilities. "}};
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
			for(int i=0; i<names.length; i++)
			{
					//System.out.println(names[i][1]);
				
				if(names[i][0].equals(receivedMesssage))
				{
					System.out.println(names[i][1]);
					String sendMessage=names[i][1];
			
					byte[] sendBytes = sendMessage.getBytes();
					DatagramPacket dpSend = new DatagramPacket(sendBytes, sendBytes.length,dpReceive.getAddress(),dpReceive.getPort());
					ds.send(dpSend);
					
			//	sendMessage = new String(names[i][1]);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		}
		System.out.println("Closed");
		ds.close();
	}
}