import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient2 
{
	public static void main(String[] args) throws IOException, SocketException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 2525;
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket(ip,port);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		String ans = dis.readUTF();
		System.out.println("Answer From the Server: " + ans);
		
		
	
	}
}


