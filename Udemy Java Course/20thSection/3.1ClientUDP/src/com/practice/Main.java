package com.practice;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();
            
            Scanner scanner = new Scanner(System.in);
            String userInput;
            while(true){
                userInput = scanner.nextLine();
                
                if(userInput.equals(".")) break;
                
                byte[] buffer = userInput.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                
                socket.send(packet);
                
                //optionally receiving the server response
                socket.receive(packet);
                System.out.println("From server: " + new String(buffer, 0, packet.getLength()));
                
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
