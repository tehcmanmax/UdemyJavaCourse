package com.practice;

import static com.practice.ThreadColour.*;

public class Main {

    public static void main(String[] args){
        System.out.println(ANSI_GREEN + "Hi from Main thread");

        Thread myRun = new Thread(new MyRunnable());
        myRun.start();
        //myRun.interrupt(); //interrupts the thread

        Thread anotherThr = new AnotherThread();
        anotherThr.start();

        new Thread() {
            @Override
            public void run(){
                try{
                    myRun.join(/*2000*/); // means this thread (new Thread) will continue after myRun thread finishes
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(ANSI_RED + "Hi from annonymous class");
            }
        }.start();
    }
}
