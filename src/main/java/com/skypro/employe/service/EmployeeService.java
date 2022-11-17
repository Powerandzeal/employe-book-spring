package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors ;

@Service

public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();
    private static int average;

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getSecondName() == null) {
            throw new IllegalArgumentException("Employee Name should be set");
        }
        Employee employee = new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getSecondName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public OptionalInt getMinSalary() {
        return employees.values().stream().mapToInt(Employee::getSalary).min();
    }

    public OptionalInt getMaxSalary() {
        return employees.values().stream().mapToInt(Employee::getSalary).max();
    }

    public double findAverageSalary() {
        return (double) getSalarySum() / employees.size();
    }
//    public OptionalDouble findAverageSalary() {
//        return employees.values().stream().mapToDouble(Employee::getSalary).average()/employees.size();
//    }


    public Map<Integer, Employee> employeeHigherThemAverageSalary() {
        return employees
                .values()
                .stream()
                .filter(s -> s.getSalary() > findAverageSalary())
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
    }


}
