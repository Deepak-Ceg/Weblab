import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer
{
	public static void main(String[] args) throws IOException, SocketException
	{
		ServerSocket ss = new ServerSocket(3535);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while(true)
		{
			String input = dis.readUTF();
			if(input.equals("bye"))
				break;
			System.out.println("Equation: " + input);
			int result=0;
			StringTokenizer st = new StringTokenizer(input);
			int operand1 = Integer.parseInt(st.nextToken());
			String operator = st.nextToken();
			int operand2 = Integer.parseInt(st.nextToken());
			
			if(operator.equals("+"))
			{
				result = operand1 + operand2;
			}
			else if(operator.equals("-"))
			{
				result = operand1 - operand2;
			}
			else if(operator.equals("*"))
			{
				result = operand1 * operand2;
			}
			else if(operator.equals("/"))
			{
				result = operand1 - operand2;
			}
			dos.writeUTF(Integer.toString(result));
		}
	}
}