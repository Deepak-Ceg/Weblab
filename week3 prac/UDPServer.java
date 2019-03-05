import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer
{
  public static void main(String args[]) throws IOException, SocketException, UnknownHostException{

      int port = 3434;
      DatagramSocket ds = new DatagramSocket(port);


      while(true)
      {

      Scanner sc =  new Scanner(System.in);
      byte[] receiveBytes = new byte[1024];
      DatagramPacket dpReceive = new DatagramPacket(receiveBytes, receiveBytes.length);

      ds.receive(dpReceive);
      String receiveMessage = new String(dpReceive.getData()).trim();
      if(receiveMessage.equals("bye")){


          System.out.println("bye");
          break;
      }

      System.out.println(receiveMessage);

      String sendMessage = "hi";
      byte[] sendBytes = sendMessage.getBytes();
      DatagramPacket dpSend = new DatagramPacket(sendBytes, sendBytes.length,dpReceive.getAddress(), dpReceive.getPort());

      ds.send(dpSend);
    }


  }



}
