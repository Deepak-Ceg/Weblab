import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient
{


  public static void main(String args[]) throws IOException, SocketException, UnknownHostException
    {

      DatagramSocket ds = new DatagramSocket();
      InetAddress ip = InetAddress.getLocalHost();
      int port = 3434;

      Scanner sc = new Scanner(System.in);

      while(true){


try{
        String input = sc.nextLine();



        byte[] sendBytes = input.getBytes();

        DatagramPacket dpSend = new DatagramPacket(sendBytes, sendBytes.length,ip,port);
        ds.send(dpSend);

        if(input.equals("bye")){

            System.out.println("Bye");


        }


                    byte[] recvBytes = new byte[1024];
                    DatagramPacket dpReceive = new DatagramPacket(recvBytes, recvBytes.length);
                    ds.receive(dpReceive);

                    String receivedMesssage = new String(dpReceive.getData());
                    System.out.println(receivedMesssage);


      }catch(Exception e){


        System.out.println(e);
      }




      }




  }
}
