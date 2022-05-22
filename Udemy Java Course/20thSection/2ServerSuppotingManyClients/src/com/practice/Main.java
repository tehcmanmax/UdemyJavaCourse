package com.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(4444)){
            while(true){
                System.out.println("Waiting for the client");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                MultipleClients clientThread = new MultipleClients(clientSocket);
                clientThread.start();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
}


class MultipleClients extends Thread {
    private Socket clientSocket;
    
    public MultipleClients(Socket socket){
        this.clientSocket = socket; //broadcasts on port 4444
    }
    
    
    @Override
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // InputStreamReader wrapper to read input stream
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            while(true){
                String clientInput = in.readLine(); //error was here; I should keep in.readLine output in String!!!!!
                
                //Thread.sleep(10000); FOR VERIFYING THE TIMEOUT ON THE CLIENT SIDE
                
                if(clientInput.equals(".")){//terminal operation
                    out.println("Goodbye, client");
                    break;
                }
                else if(clientInput.equals("hi")){
                    out.println("Hello, client");
                }
                else out.println(clientInput); //echoed
            }
        }
        /*
        catch(InterruptedException e){
            e.printStackTrace();
        }
        */
        catch(IOException  e){
            e.printStackTrace();
        }
        finally{
            try{
                clientSocket.close();
            }
            catch(IOException e){
                // Oh, well!
            }
        }
    }
    
}

