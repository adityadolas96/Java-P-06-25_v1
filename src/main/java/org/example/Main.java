package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Employee{
    private int id;
    private String name;
    private String department;
    private double salary;
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(new Employee(1,"aditya","IT",30000),
                new Employee(2,"avinash", "IT",40000),
                new Employee(3,"arvind","Lead",90000));

        // Second Highest Salary
        Optional<Double> secondHighestSalary = employee.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();

        System.out.println(secondHighestSalary.get());

        // Highest Salary
        Optional<Double> max = employee.stream()
                .map(Employee::getSalary).max(Double::compareTo);

        System.out.println(max.get());

        // Group Employee by department
        Map<String, List<Employee>> empDepartmentMap = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empDepartmentMap);
    }
}