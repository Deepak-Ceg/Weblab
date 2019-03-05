import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient1
{

  public static void main(String args[]) throws IOException, SocketException
  {

    InetAddress ip = InetAddress.getLocalHost();
    int port = 3535;
    Socket s = new Socket(ip,port);
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    Scanner sc = new Scanner(System.in);
    while(true)
    {

        String input = sc.nextLine();
        dos.writeUTF(input);
        if(input.equals("bye"))
        {

            System.out.println("Bye");

        }

        String result = dis.readUTF();
        System.out.println(result);


    }



  }
}
