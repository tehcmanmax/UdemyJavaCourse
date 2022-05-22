package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort {
    List<Employee> employees = new ArrayList<>();

    public void addingEmployees(){
        employees.add(new Employee("Bob"));
        employees.add(new Employee("Arnold"));
        employees.add(new Employee("Donald"));
        employees.add(new Employee("Crag"));
    }

    public void overridingCollSort(){
        Collections.sort(employees, new Comparator<>() {
            /*            @Override
                        public int compare(Employee o1, Employee o2){
                            if(o1.getName().compareTo(o2.getName()) == 0)  //alternatively it's possible to use the equals()
                                return 0;
                            else if((o1.getName().compareTo(o2.getName())) > 0)
                                return 1;

                            return -1;*/

            //Shorten form
            @Override
            public int compare(Employee o1, Employee o2){
                return o1.getName().compareTo(o2.getName());
            }
        });
    }


    public void printingEmployees(){
        for(Employee e : employees)
            System.out.println(e.getName());
    }

    public static void main(String[] args){
        UsingLambda o = new UsingLambda();
        o.addingEmployees();
        o.overridingCollSort();

        //IMPORTANT
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase(); // it is like an anonymous class, so I can implenent in the uc
        String sillyString = uc.UpperConcatMethod(o.employees.get(0).getName(), o.employees.get(1).getName());
        System.out.println(sillyString);
        //IMPORTANT

        o.printingEmployees();


    }
}

class UsingLambda extends CollectionsSort { //implementing in Lambda

    @Override
    public void overridingCollSort(){
        Collections.sort(employees, (o1, o2) ->
                o1.getName().compareTo(o2.getName()));
        System.out.println("Lambda expression completed");

    }



}

class Employee {
    private final String name;

    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

@FunctionalInterface
interface UpperConcat {
    String UpperConcatMethod(String o1, String o2);
}
