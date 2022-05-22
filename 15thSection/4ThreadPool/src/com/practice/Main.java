package com.practice;
// Java program to illustrate
// ThreadPool

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Task class to be executed (Step 1)
class Task implements Runnable {
    private final String name;

    public Task(String s){
        name = s;
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public void run(){
        try{
            for(int i = 0; i <= 5; i++){
                if(i == 0){
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for" + " task name - " + name + " = " + ft.format(d));
                    //prints the initialization time for every task
                }
                else{
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - " + name + " = " + ft.format(d));
                    // prints the execution time for every task
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        }

        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Main {
    // Maximum number of threads in thread pool
    static final int MAX_T = 3;

    public static void main(String[] args){
        // creates five tasks
        Task r1 = new Task("task 1");
        Task r2 = new Task("task 2");
        Task r3 = new Task("task 3");
        Task r4 = new Task("task 4");
        Task r5 = new Task("task 5");

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)


        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        //returns an object of type ExecutorService . This is why we can initialize pool with this method

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        // pool shutdown ( Step 4)
        pool.shutdown();

        /* In the large amount, the following approach will take enormous resources

        (bunch of anonymous classes)
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
        new Thread(r4).start();
        new Thread(r5).start();
        */

    }
}