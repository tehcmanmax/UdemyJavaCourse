package com.timbuchalka;

/**
 * Created by dev on 11/08/15.
 */
public class HealthyBurger extends Hamburger {

    private String healthyExtra1Name;
    private double healthyExtra1Price;

    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye");
    }

    public void addHealthAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    //https://www.youtube.com/watch?v=neOvVLpy918
    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger(); //super calls itemizeHamburger() from the parent class, thus breaks override!!!
        if(this.healthyExtra1Name != null) {
            hamburgerPrice += this.healthyExtra1Price;
            System.out.println("Added " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
        }
        if(this.healthyExtra2Name != null) {
            hamburgerPrice += this.healthyExtra2Price;
            System.out.println("Added " + this.healthyExtra2Name + " for an extra " + this.healthyExtra2Price);
        }
        return hamburgerPrice;
    }
}

/* i could use smth like
        setPrice(getPrice()+this.healthyExtra1Price);
        return getPrice();
 but will not take into account the additions from them parent class
*/