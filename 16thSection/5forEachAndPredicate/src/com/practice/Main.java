package com.practice;
/*
 * TASK
 * Implement DRY concept for giving either first or last names
 * */

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

class ImplConsumer implements Consumer<Employee> {

    @Override
    public void accept(Employee o){
        System.out.println(o);
    }

}

public class Main {
    static List<Employee> employees = new LinkedList<>();
    static Function<Employee, String> getFirstName1 = e -> e.getName().substring(0, e.getName().indexOf(' '));
    static Function<Employee, String> getLastName1 = e -> e.getName().substring(e.getName().indexOf(' ') + 1);

    static{ //gets executed without crteating an object of type Main
        employees.add(new Employee("Mari Bright", 26));
        employees.add(new Employee("Alex Dark", 32));
        employees.add(new Employee("Max Thompson", 21));
        employees.add(new Employee("John Henshaw", 25));
        employees.add(new Employee("Grant Benny", 19));

        /*
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2){
                return o1.getName().compareTo(o2.getName());
            }
        });

        EQUAL TO
        */

        /*
        employees.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        EQUAL TO
        */

        employees.sort(Comparator.comparing(Employee::getName)); //the shortest way to compare sort in the collection

    }

    public void printingByAge(String textAge, Predicate<Employee> ageCondition){
        System.out.println(textAge);
        employees.forEach(employee -> {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });
    }

    public static void main(String[] args){
        Main main = new Main();

        main.printingByAge("Getting employees by age > 25", employee -> employee.getAge() > 25);
        //equivalent to
        main.printingByAge("Getting employees by age < 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee){
                return employee.getAge() < 25;
            }
        });


        /* 1ST WAY
        main.employees.forEach(employee -> {
            System.out.print( employee.getName() + " ");
            System.out.println(employee.getAge());
        });
         */

        /* 2ND WAY
        ImplConsumer o = new ImplConsumer(); //implementing Consumer
        main.employees.forEach(o);
        */

        System.out.println("==================================");
        //printing entries by their last names
        main.employees.forEach(employee -> { // 1 argument is required because it says in the Iterable functonal interface
            String[] lastNames = employee.getName().split(" ");
            System.out.println("Last name is " + lastNames[1]);

            /*
               OR
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println(lastName);
            */
        });
        System.out.println("==================================");
        System.out.println("Implementing the same thing but using Function interface");
        Function<Employee, String> getLastName = e -> e.getName().substring(e.getName().indexOf(' ')); //saving the function in the object variable
        main.employees.forEach((Employee e) -> System.out.println("Last name is" + getLastName.apply(e))); //Employee is optional

        System.out.println("==================================");
        System.out.println("Implementing the same thing but using longerFunction()");
        main.employees.forEach(e -> System.out.println("Last name is" + longerFunction(e))); //it knows about e type from employees

        System.out.println("==================================");
        System.out.println("Getting first or last name using DRY concept");



        /*
                Function<Predicate<Boolean>, String> getFirstOrLastName = condition -> {
            if(condition.test(Boolean condition))
                return getLastName1.apply(getFirstName1.apply(getFirstName1.apply(getFirstName1.apply())));
            else
                return getFirstName1;
        };

            Predicate<Boolean> getFirstOrLastName = e -> {
            if(e) return getLastName1;
            return getFirstName1;
            */

        System.out.println(getFirstOrLastName(getFirstName1, main.employees.get(4)));
        System.out.println(getFirstOrLastName1.apply(getLastName1.apply(main.employees.get(4))));
    }

    //DRY CONCEPT IMPLEMENTED; method takes a Function interface
    private static String getFirstOrLastName(Function<Employee, String> getName, Employee e){ //it is more understandable
        return getName.apply(e);
    }

    private static Function<String, String> getFirstOrLastName1 = s -> s;
    //END OF THE DRY CONCEPT

    private static String longerFunction(Employee e){
        return e.getName().substring(e.getName().indexOf(' '));
    }

}

class LastClassHere extends Main {
    private static Function<String, String> concatNumber = s -> s + " " + new Random().nextInt(100); //pseudo random age
    private static Function<Employee, String> chained = getFirstName1.andThen(concatNumber);
    private static Function<Employee, String> chained1 = concatNumber.compose(getFirstName1);

    private static BiFunction<Employee, Integer, String> biFunction = ((employee, age) -> {
        String firstName = getFirstName1.apply(employee);
        return firstName + " " + age;
    });

    public static void main(String[] args){
        System.out.println("==================================");
        System.out.println("Working at the " + LastClassHere.class.getSimpleName() + "class");
        System.out.println("Using andThen():");

        String temp = chained.apply(employees.get(3));
        System.out.println(temp);

        System.out.println("Using compose():");
        System.out.println(chained1.apply(employees.get(3))); //achieved the same result

        System.out.println("Using BiFunction<Employee, Integer, String>:");
        System.out.println(biFunction.apply(employees.get(4), 21));

    }
}