package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
class Employee{
    private int id;
    private String name;
    private double salary;
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(new Employee(1,"aditya",30000),
                new Employee(2,"avinash", 40000),
                new Employee(3,"arvind",90000));

        // Second Highest Salary
        Optional<Double> secondHighestSalary = employee.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();

        // Highest Salary
        Optional<Double> max = employee.stream()
                .map(Employee::getSalary).max(Double::compareTo);

        System.out.println(secondHighestSalary.get());
        System.out.println(max.get());
    }
}