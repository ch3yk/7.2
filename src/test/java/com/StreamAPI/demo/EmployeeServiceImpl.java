package com.StreamAPI.demo;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Ковалюсь", "Иван", 60_000, 2),
            new Employee("Голуб", "Богдан", 50_000, 4),
            new Employee("Голубцов", "Валерий", 70_000, 2),
            new Employee("Голубцов", "Ростислав", 90_000, 1)
    ));

    @Override
    public Employee minimumSalary(int departmentId) {
        return staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public ArrayList<Employee> departmentsAll(int departmentId) {
        return (ArrayList<Employee>) staff
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> All() {
        return staff
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        HttpParser StringUtils = null;
        if (!StringUtils.isAlpha(Integer.parseInt(firstName)) && !StringUtils.isAlpha(Integer.parseInt(lastName))) {
            throw
                    new RuntimeException();
        }
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        staff.add(employee);
        return employee;
    }

}