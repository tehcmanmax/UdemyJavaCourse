package com.practice;

import static com.practice.ThreadColour.ANSI_GREEN;
import static com.practice.ThreadColour.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(ANSI_GREEN + "From implemented Runnable " + getClass().getName().substring(13));

        try{
            Thread.sleep(3000); // thread waits for 3 seconds
            System.out.println(ANSI_RED + "Waited 3 seconds");
        }
        catch(InterruptedException e){
            System.out.println(ANSI_RED + "Cannot wait 3 seconds, I got interrupted");
        }
    }
}
