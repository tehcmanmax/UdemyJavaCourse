package com.practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args){
        BankAccount sharedBankAccount = new BankAccount("1-558-321", 1000);

        // Person 1
        new Thread() {
            @Override
            public void run(){
                sharedBankAccount.deposit(300.00);
                System.out.println("deposit 300");

                sharedBankAccount.withdraw(50.00);
                //System.out.println("Balance: " + sharedBankAccount.getBalance()); // expected Balance: 1250
            }
        }.start();

        // Person 2
        new Thread() {
            @Override
            public void run(){
                sharedBankAccount.deposit(50);
                System.out.println("deposit 50");

                sharedBankAccount.withdraw(100.00);
                System.out.println("withdraw 100");
                System.out.println("Balance: " + sharedBankAccount.getBalance()); // expected Balance: 1200
            }
        }.start();

    }


}


class BankAccount {
    private final Lock lock = new ReentrantLock();
    private double balance;
    private final String accountNumber;
    private Boolean transactionStatus;

    public BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // START OF CRITICAL SECTION
    public void deposit(double amount){
        synchronized(transactionStatus){
            try{
                if(!lock.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println("lock is busy");
                    return;
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            try{
                balance += amount;
                System.out.println(Thread.currentThread().getName() + " balance += amount");
                transactionStatus = true;
            }
            catch(Exception e){
            }
            finally{
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "Transaction status = " + transactionStatus);
        }
    }

    public void withdraw(double amount){
        synchronized(transactionStatus){
            try{
                if(!lock.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println("lock is busy");
                    return;
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            try{
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " balance -= amount");
                transactionStatus = true;
            }

            catch(Exception e){
            }
            finally{
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "Transaction status = " + transactionStatus);
        }
    }
    // END OF CRITICAL SECTION

    public double getBalance(){
        return balance;
    }
}

class ImplementingRunnable {
    public static void main(String[] args){
        BankAccount sharedBankAccount = new BankAccount("1-558-321", 1000);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                sharedBankAccount.deposit(300.00);
                System.out.println("deposit 300");

                sharedBankAccount.withdraw(50.00);
                System.out.println("withdraw 50");
            }
        });
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run(){
                sharedBankAccount.deposit(203.75);
                System.out.println("deposit 203.75");

                sharedBankAccount.withdraw(100.00);
                System.out.println("withdraw 100");
                System.out.println("Balance: " + sharedBankAccount.getBalance()); // expected Balance: 1353.75
            }
        }).start();

    }
}