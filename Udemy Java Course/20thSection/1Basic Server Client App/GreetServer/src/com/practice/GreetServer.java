package com.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//SERVER WON'T PRINT ANYTHING ON ITS SIDE, ONLY SENDS THE OUTPUT TO A CLIENT
public class GreetServer {
    
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(4444)){
            
            System.out.println("Waits for a client");
            Socket clientSocket = serverSocket.accept();//suspends till receives the    socket from a client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            while(true){
                System.out.println("Entered a while loop");
                String clientCommand = in.readLine();
                if(clientCommand.equals("exit")){
                    out.println("Goodbye, client");
                    break;
                }
                if(clientCommand.equals("hi, server")){
                    out.println("hi, client");
                }
                out.println("from server: " + clientCommand);
            }
        }
        catch(IOException e){
            System.out.println("Issue on the server side");
            e.printStackTrace();
        }
    }
}
