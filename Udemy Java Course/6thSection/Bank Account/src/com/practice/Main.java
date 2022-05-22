package com.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner usr = new Scanner(System.in);

        int check = 0;

        System.out.println("enter acc number ");
        int accountNumb = usr.nextInt();
        System.out.println("enter acc number ");
        double accounBal = usr.nextDouble();


        Account account = new  Account(accountNumb, accounBal);
        /*account.setBalance(1200.43);
        System.out.println("u got " + account.getBalance());

        System.out.println("set email: ");
        String mail = usr.nextLine();
        account.setEmail(mail);
        System.out.println("u entered: "+account.getEmail());

        System.out.println("would you like to withdraw? yes or no: ");
        String answer = usr.nextLine();

        if (answer.contains("yes")){
            System.out.println("enter amount to withdraw");
            double amountWithdraw = Double.parseDouble(usr.nextLine());
            check =(int) account.withdraw(amountWithdraw);

            System.out.printf("left amount: %.3f", account.getBalance());
//            left amount %.3d", account.getBalance()

        }

        else{
            System.out.println("no? understandable. have a nice cock");
        }*/
    }
}
