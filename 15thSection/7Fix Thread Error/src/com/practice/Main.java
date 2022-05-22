package com.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*CHALLENGE #7
 * Fix livelock error*/

/*TASK
* 1. make alternative solution to work
* 2. Bug in Challenge 7 (Lecture 289)
* */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        BankAccount account1 = new BankAccount("12345-678", 500.00);
        BankAccount account2 = new BankAccount("98765-432", 1000.00);

        Thread t = new Thread(new Transfer(account1, account2, 10.00), "Transfer1"); // runnable inside in the Thread anonymous
        t.start();
        t.join();

        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized double getBalance(){
        return balance;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try{ // game changer; 2nd try is to add finally block
                try {
                    // Simulate database access
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            }
            finally{
                lock.unlock();
            }
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
            try{
                try {
                    // Simulate database access
                    Thread.sleep(100);
                }

                catch (InterruptedException e) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;

            }
            finally{
                lock.unlock();
            }
        }
        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            }
            else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                while (!deposit(amount)) {
                    continue;
                }
            }
        }

        return false;
    }
}

class Transfer implements Runnable {
    private BankAccount sourceAccount, destinationAccount;
    private double amount;

    Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount){
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run(){
        while(!sourceAccount.transfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed\n", Thread.currentThread().getName());
        System.out.println("1st bank: " + sourceAccount.getBalance());
        System.out.println("2nd bank: " + destinationAccount.getBalance());
    }
}

/*WHY I NEED .join or thread timer

* Having the same problem. I actually dowloaded already "solved" xD
From my perspective livelock still exists and it looks this way:

1) Thread 1 an 2 lock for withdraw
2) One of threads is always little faster, let's say Thread 1 for example
3) Thread 1 finishes, tries to deposit on Thread 2 but this one has lock so the fail comes. Thread 1 locks again to deposit back.
4) Thread 2 asks Thread 1 to deposit, but lock is on. It fails, deposit goes back with lock on.

And it keeps looping until luckily locks won't interfere each other.
My solution was simple - just added some timer for trylock
example

    public boolean withdraw(double amount) {
            try {
                if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    try {
                        // Simulate database access
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    balance -= amount;
                    System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                    return true;
                }
            } catch (InterruptedException e) {
                return false;
            } finally {
                lock.unlock();
            }
        return false;
    }
* */