package com.practice;

/*Reference code if I need to recap inner class concept, syntax*/

class Outer {
    private int x = 1;

    //local inner class
    class Inner {
        private int y = 2;

        public void bye() {
            hello(); //However, outer class does not have the access to inner class
            System.out.println("1. Inner local class wishes you a nice day");
        }
    }

    public void displayPrivateClass() { //I have to use method to show the private class!!!
        InnerPrivate accessPrivate = new InnerPrivate();
        accessPrivate.fromPrivate();
    }

    public void hello() {
        System.out.println("Hi from outer class");
    }

    //local inner private class
    private class InnerPrivate {
        public void fromPrivate() {
            System.out.println("2. Hello from private inner local class");
        }
    }

    //static nested class
    public static class NestedStatic {
        public void sayHi() {
            System.out.println("4. I'm from public static nested class");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("4 types of nested class:\n");
        Outer outer = new Outer();
        Outer.Inner obj = outer.new Inner();

//        System.out.println(obj.y);
//        System.out.println(outer.x);
        obj.bye();

        outer.displayPrivateClass();

        Outer outer2 = new Outer() { //anonymous class
            @Override
            public void hello() {
                //noinspection SpellCheckingInspection
                System.out.println("3. Sike! Goodbye(anonymous class)"); //overriding
            }
        };
        outer2.hello();

        Outer.NestedStatic stat = new Outer.NestedStatic();
        stat.sayHi();
    }
}