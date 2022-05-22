package com.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employeeList;
    private String departmentName;

    public Department(String departmentName){
        employeeList = new ArrayList<>();
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

}
