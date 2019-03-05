import java.io.*;
import java.net.*;
import java.util.*;
public class TCPServer1
{

  public static void main(String args[]) throws IOException, SocketException
  {

    ServerSocket ss = new ServerSocket(3535);
    Socket s = ss.accept();
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    while(true){

    String input = dis.readUTF();
    if(input.equals("bye")){
      System.out.println("Bye");
    }

    StringTokenizer st = new StringTokenizer(input);
    int op1 = Integer.parseInt(st.nextToken());
    String op = st.nextToken();
    int op2 = Integer.parseInt(st.nextToken());
    int result = 0;
    if(op.equals("+"))
    {
        result = op1 + op2;


    }

    dos.writeUTF(Integer.toString(result));


  }


  }



}
