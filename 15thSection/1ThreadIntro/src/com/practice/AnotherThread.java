package com.practice;

import static com.practice.ThreadColour.ANSI_CYAN;

public class AnotherThread extends Thread{
    @Override
    public void run(){
        System.out.println(ANSI_CYAN + "Overriden thread");

    }
}
