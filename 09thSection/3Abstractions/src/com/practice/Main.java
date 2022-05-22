package com.practice;

/*Shows differences between abstraction and interface*/

public class Main {

    public static void main(String[] args) {
        Cat homeCat = new Cat("Boris");
        System.out.println("My name is " + homeCat.getAnimalName());
        homeCat.move();
        homeCat.eat();
        homeCat.jump();

        Fish homeFish = new Fish("Gold Fish");
        System.out.print("\nThis fish is ");
        homeFish.move();
    }
}
