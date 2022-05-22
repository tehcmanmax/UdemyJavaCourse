package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    
    public static void main(String[] args){
        try{
            URL url = new URL("https://example.org/");
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            
            while(bufferedReader.readLine() != null){
                System.out.println(bufferedReader.readLine());
            }
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
