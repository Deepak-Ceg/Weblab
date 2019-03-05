import java.io.*;
import java.net.*;
import java.util.*;

public class TCPMultiServer
{
	public static void main(String[] args) throws IOException, SocketException
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
		System.out.println("Hey Client! Tell me the number?");
		String num = sc.nextLine();
		if(num.equals("1"))
		{
		System.out.println("Client 1 is connected");
		ServerSocket ss1 = new ServerSocket(3535);
		Socket s1 = ss1.accept();
		DataInputStream dis1 = new DataInputStream(s1.getInputStream());
		
			String input = dis1.readUTF();
		
			System.out.println("Input Received from Client1 : " + input);
		
		
		ss1.close();
		s1.close();
		
		ServerSocket ss3 = new ServerSocket(1515);
		Socket s3 = ss3.accept();
		DataOutputStream dos3 = new DataOutputStream(s3.getOutputStream());
		
			//dos2.writeUTF(input);
			dos3.writeUTF(input);
		
		
		ServerSocket ss2 = new ServerSocket(2525);
		Socket s2 = ss2.accept();
		DataOutputStream dos2 = new DataOutputStream(s2.getOutputStream());
		
			//dos2.writeUTF(input);
			dos2.writeUTF(input);
		
		}
		}
	}
}