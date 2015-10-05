package sample;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by nirbelelti on 16/09/15.
 */
public class Sender  {

   //     private static int LISTE_PORT = 9001;
        private static final int SEND_PORT = 9000;
        private static final String IP = "10.111.180.161";






    public static void sent(Integer fildSent,String  playerSent) throws Exception {

        String msg = (""+fildSent+"," +playerSent);

        InetAddress IPAddress = InetAddress.getByName(IP);
        //InetAddress IPAddress = InetAddress.getLocalHost();

            DatagramSocket sendSocket = new DatagramSocket();


            Thread sendThread = new Thread(() ->
            {
                byte[] data = new byte[1024];

                    data = msg.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, SEND_PORT);
                    try {
                        sendSocket.send(sendPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
             //   }
            });


            sendThread.start();


        }

    }

