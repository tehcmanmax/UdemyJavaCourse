package com.practice;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Burger{}

class BurgerFactory{

    public Burger createBurger(){
        return new Burger();
    }
}
class HealthyBurger extends BurgerFactory{
    @Override
    public HealthyBurger createBurger() {
        return new HealthyBurger();
    }

}