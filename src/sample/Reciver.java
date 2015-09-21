package sample;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by nirbelelti on 16/09/15.
 */
public class Reciver  {

        private static int LISTE_PORT = 9000;
  //      private static final int SEND_PORT = 9000;
      //  private static final String IP = "10.111.176.175";


        public static void main(String[] args) throws Exception {

            InetAddress IPAddress = InetAddress.getLocalHost();
            DatagramSocket receiveSocket = new DatagramSocket(LISTE_PORT);


            Thread receiveThread = new Thread(() ->
            {
                byte[] data = new byte[10];

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(data, data.length);

                    try {
                        receiveSocket.receive(receivePacket);
                        String msg = new String(receivePacket.getData());
                        msg.trim();
                        if(msg.length()>0) {

                            System.out.println(msg);
                            new Controller().updateBoard(msg);
                            //controller.updateBoard(msg);
                            msg = null;
                            data = new byte[10];

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


//
//                Sender conf = new Sender();
//
//            try {
//                   conf.sent(0 ,"O,K");
//              } catch (Exception e) {
//
//              }
                 //   break;
                  }
            });



            receiveThread.start();

        }



    }







