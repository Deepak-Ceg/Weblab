import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient 
{
	public static void main(String[] args) throws IOException, SocketException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 3535;
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket(ip,port);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while(true)
		{
			System.out.println("Enter the Input:");
			String inp = sc.nextLine();
			dos.writeUTF(inp);
			if(inp.equals("bye"))
				break;
			String ans = dis.readUTF();
			System.out.println("Answer From the Server: " + ans);
		}
	}
}


