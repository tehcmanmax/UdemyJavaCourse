package com.practice;

public class Main {

    public static void main(String[] args){
        new Thread(() -> System.out.println("Using the lambda expression!")).start();

        new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Using the anonymous class!");
            }
        }).start();
    }
}
