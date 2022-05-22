package com.practice;
/* FINISH THE  IMPLEMENTATION FROM THE SCREENSHOT IN THE LAST DOCUMENT
 * */
// flatmap explained
// https://www.youtube.com/watch?v=sVX421gaRT4
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final List<String> bingoNumbers = Arrays.asList(
            "N40", "N59",
            "P12", "P01", "p88",
            "L32", "L13", "L01");

    private static List<String> bingoPsNumbers = new ArrayList<>();

    public static void main(String[] args){
        //fulfillingSortingAndPrinting_Lambda();
        implementingWithStreams();
        fulfillingSortingAndPrinting_Lambda();

        new BuildingStreamsFromScratch(); //Just to print the operations done in the BuildingStreamsFromScratch class

        //DON'T REMOVE
        List<Department> departments = creatingEmployeesWithDepartments();

        usingFlatMaps(departments);

        ;
        usingCollectStreamMethod(departments);

    }

    private static List<Department> creatingEmployeesWithDepartments(){
        Department mainDepartment = new Department("Lead Department");
        Department hr = new Department("HR Department");

        Employee employee1 = new Employee("Mari Bright", 26);
        Employee employee2 = new Employee("Alex Dark", 32);
        Employee employee3 = new Employee("Max Thompson", 21);
        Employee employee4 = new Employee("Grant Benny", 19);

        mainDepartment.getEmployeeList().add(employee1);
        mainDepartment.getEmployeeList().add(employee2);
        mainDepartment.getEmployeeList().add(employee3);
        mainDepartment.getEmployeeList().add(employee4);

        hr.getEmployeeList().add(employee1);

        List<Department> departments = Arrays.asList(mainDepartment, hr); //adding departments to the list
        return departments;
    }

    private static void usingFlatMaps(List<Department> departments){
        System.out.println("==============================");
        System.out.println("Start using flatMap()");
        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .forEach(s -> System.out.println(s.getName()));



        System.out.println("Converting stream to array with terminal method toArray():");
        int[] storedAges = departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .mapToInt(Employee::getAge)
                .toArray();
        for(int storedAge : storedAges)
            System.out.println(storedAge);



        System.out.println("Using reduce method to print the youngest employee:");
        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .reduce((firstEmployee, secondEmployee) -> firstEmployee.getAge() < secondEmployee.getAge() ? firstEmployee : secondEmployee)
                .ifPresent(System.out::println);
    }

    private static void usingCollectStreamMethod(List<Department> departments){
        System.out.println("==============================");
        System.out.println("Using collect method without custom collect:");
        List<String> storedNames1 = departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .map(Employee::getName)
                .collect(Collectors.toList());
        storedNames1.forEach(System.out::println);

        System.out.println("Using collect method with custom collect:");
        List<String>storedNames2 = departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .map(Employee::getName)
                .collect(LinkedList<String>::new, LinkedList<String>::add, LinkedList<String>::addAll); //supplier, accumulator,
        storedNames2.forEach(System.out::println);
    }

    private static void fulfillingSortingAndPrinting_Lambda(){
        System.out.println("==============================");
        System.out.println("Grouping and sorting with Lambdas (syntax is much longer)");

        bingoNumbers.forEach(stringBingoNumbers -> {
            if(stringBingoNumbers.toUpperCase().contains("P"))
                bingoPsNumbers.add(stringBingoNumbers);
        });

        bingoPsNumbers.sort(String::compareTo);
        bingoPsNumbers.forEach(System.out::println);

    }

    private static void implementingWithStreams(){
        System.out.println("==============================");
        System.out.println("Grouping and sorting with streams (no duplicates)");
        bingoPsNumbers = bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.contains("P"))
                .sorted() //(e1, e2) -> e1.compareTo(e2)
                //.forEach(System.out::println)
                .collect(Collectors.toList());
                /*map() is used to transform one object into other by applying a function.
                That's why the Stream. map(Function mapper) takes a function as an argument*/

        bingoPsNumbers.forEach(System.out::println);
    }
}

class BuildingStreamsFromScratch extends Main {
    static Stream<String> pValuesBingo = Stream.of("P12", "P01", "P88");
    static Stream<String> nValuesBingo = Stream.of("N40", "N59", "N59");
    static Stream<String> concatStreams = Stream.concat(pValuesBingo, nValuesBingo);

    static{
        System.out.println("==============================");
        System.out.println("Building Streams From Scratch");
        System.out.println(concatStreams
                                   .distinct()
                                   .peek(System.out::println)
                                   .count()
        );
    }
}