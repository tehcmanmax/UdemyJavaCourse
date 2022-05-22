package com.practice;

import java.io.IOException;
import java.net.*;

public class Main {
    
    public static void main(String[] args){
        try{
            DatagramSocket socket = new DatagramSocket(5000);
            while(true){
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length); //creates packet-placeholder for+
                // the upcoming datagram(UDP) connection
                
                socket.receive(packet); //receives and saves the client packet into DatagramPacket packet variable -> buffer
                System.out.println("Received packet: " + new String(buffer, 0, packet.getLength()));
                
                //---------
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                
                packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort); //preparing the packet to be sent to the client
                socket.send(packet);
                
            }
        }
        catch(SocketException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
