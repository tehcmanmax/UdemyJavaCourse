package com.practice;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedWriter userData = new BufferedWriter(new FileWriter("saving user input.txt"));

        byte[] data = new byte[12];

        System.in.read(data); // saves in bytes

        for(byte datum : data){
            userData.write(datum); // converts and saves to the userData
            System.out.write(datum); // converts and saves to the buffer
        }
        System.out.flush(); // writes from the buffer to terminal

        // Closes the stream
        System.out.close();
        userData.close();
    }
}
