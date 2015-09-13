package sample;

//Created by Pawel on 2015-09-10.

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class NetworkConnection {
    private static int LISTE_PORT = 9000;
    private static final int SEND_PORT = 9001;
 //   private static final String IP = "10.111.176.191";


    public static void main(String[] args) throws Exception{

        // im using my local host just for testing
        InetAddress IPAddress = InetAddress.getLocalHost();

        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receiveSocket = new DatagramSocket(LISTE_PORT);


        //Created an instance of Controller class so i could call the variable sendmove from Controller. I gave it a new name
        //
    Controller controller = new Controller();
        String newvariable =  controller.sendmove;








        Thread sendThread = new Thread(() ->
        {
            byte[] data = new byte[1024];

            while (true){
              //  System.out.println("Enter your msg:");

                data = newvariable.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, SEND_PORT);
                try {
                    sendSocket.send(sendPacket);
                  //  System.out.println(newvariable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread receiveThread = new Thread(() ->
        {
            byte[] data = new byte[1024];

            while (true){
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                try {
                    receiveSocket.receive(receivePacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Received: "+ new String(receivePacket.getData()));

            }
        });

      //  if (controller.setMove1())

            sendThread.start();


        receiveThread.start();



    }
}
