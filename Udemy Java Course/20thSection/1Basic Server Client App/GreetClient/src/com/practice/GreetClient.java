package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class GreetClient {
    public static void main(String[] args){
        try(Socket clientSocket = new Socket("localhost", 4444)){
            
            //In case the server is frozen or other issues
            //clientSocket.setSoTimeout(5000); //1000ms = 1 second
    
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //ERROR IS HERE. I've use new PRINTWRITER twice!
            
            System.out.println("Enter what to send to the server:");
            Scanner userInput = new Scanner(System.in);
            String input;
            while(true){
                input = userInput.nextLine().strip();
                out.println(input);
                String response = in.readLine();
                System.out.println(response);
                
                if(input.equals("exit")) return;
            }
        }
        catch(SocketTimeoutException e){
            System.out.println("time out");
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
