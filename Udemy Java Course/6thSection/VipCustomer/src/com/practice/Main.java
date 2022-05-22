package com.practice;

public class Main {

    public static void main(String[] args) {
	VipCustomer bankUser = new VipCustomer();
        System.out.println(bankUser.getName());

        VipCustomer bankUser2 = new VipCustomer("Max", "scraptrash@gmail.com");
        System.out.println("\nname: "+bankUser2.getName()+"\nemail: "+bankUser2.getEmail()+"\nlimit: "+bankUser2.getCreditLimit());

        VipCustomer bankUser3 = new VipCustomer("Dyn Dyn",10, "feja_dyn-dyn@gmail.com");
        System.out.println("\nname: "+bankUser3.getName()+" \nemail: "+bankUser3.getEmail()+" \nlimit: "+bankUser3.getCreditLimit());
    }

}
