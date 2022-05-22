package com.practice;

public class Main {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " - from psvm");

        MyLoop myLoop = new MyLoop();

        new Thread() {
            @Override
            public void run(){
                myLoop.loop(5);
            }
        }.start();

        new Thread() {
            @Override
            public void run(){
                myLoop.loop(5);
            }
        }.start();
    }

}

class MyLoop {
    public volatile double value = 0; // volatile is for the cache coherence

    public synchronized void loop(int times){
        for(int i = 0; i < times; i++){
            this.value++;
            System.out.println(Thread.currentThread().getName() + ": " + this.value);
        }

    }
}

 class TaskRunner {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;
    }
}