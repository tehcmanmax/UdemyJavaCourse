package com.practice;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

}

class TestDeadlockExample1 {
    public static void main(String[] args){

        //ReentrantLock analog to syncronization
        ReentrantLock reentrantLock = new ReentrantLock();

        final String resource1 = "\"shared recourse 1\"";
        final String resource2 = "\"shared recourse 2\"";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run(){
                reentrantLock.lock();
                System.out.println("Thread 1: locked resource " + resource1);

                try{
                    Thread.sleep(100);
                }
                catch(Exception e){
                }

                reentrantLock.unlock();

                reentrantLock.lock();
                System.out.println("Thread 1: locked resource " + resource2);
                reentrantLock.unlock();
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run(){
                reentrantLock.lock();
                System.out.println("Thread 2: locked resource " + resource2);

                try{
                    Thread.sleep(100);
                }
                catch(Exception e){
                }

                reentrantLock.unlock();

                reentrantLock.lock();
                System.out.println("Thread 2: locked resource " + resource1);
                reentrantLock.unlock();
            }
        };


        t1.start();
        t2.start();
    }
}
