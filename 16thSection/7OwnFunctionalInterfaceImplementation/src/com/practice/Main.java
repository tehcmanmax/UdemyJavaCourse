package com.practice;


public class Main {

    public static void main(String[] args){
        Printer<String, Void> printMessage = m -> {
            System.out.println(m);
            return null;
        };
        printMessage.print("Hi");

        //anonymous object to implement the DiamondProblem interface
        new DiamondProblem(){
            void newMethod(){
                System.out.println("Created an anonymous object which implements the interface");
            }
        }.newMethod();

        System.out.println(Printer.giveDefaultMessage());

    }
}

class ClassImplementInterface implements DiamondProblem, Printer<String, Void> {

    public static void main(String[] args){

        ClassImplementInterface obj = new ClassImplementInterface();
        obj.print("Word");
        System.out.println(obj.giveMotivation());

        System.out.println("==================================================");
        System.out.println("Overriding the default interface method:");
        obj = new ClassImplementInterface(){
            @Override
            public String giveMotivation(){
                return "You have successfully overridden the motivation() method within this class!";
            }
        };
        System.out.println(obj.giveMotivation());

        System.out.println("==================================================");
        System.out.println("Using the field from the functional interface that is Supplier interface:");
        System.out.println(askingMyself.get());

        System.out.println("==================================================");
        System.out.print("Introducing a drawback for default methods -- ");
        System.out.println("com.practice.ClassImplementInterface inherits unrelated defaults for diamondProblem() from types com.practice.Printer and com.practice.DiamondProblem");
        obj.diamondProblem();
        System.out.println("Solution:");
        System.out.println("\t@Override\n" + "    public void diamondProblem(){\n" + "        Printer.super.diamondProblem();\n" + "        DiamondProblem.super.diamondProblem();\n" + "    }");
    }

    @Override
    public Void print(String s){
        System.out.println(s);
        return null;
    }

    //solving the diamond problem
    @Override
    public void diamondProblem(){
        Printer.super.diamondProblem();
        DiamondProblem.super.diamondProblem();
    }
}