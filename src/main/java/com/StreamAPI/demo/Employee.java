package com.StreamAPI.demo;


import org.springframework.util.StringUtils;
public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = StringUtils.capitalize(StringUtils.trimWhitespace(firstName.toLowerCase()));
        this.lastName = StringUtils.capitalize(StringUtils.trimWhitespace(lastName.toLowerCase()));
        this.salary = salary;
        this.departmentId = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return departmentId;
    }
}