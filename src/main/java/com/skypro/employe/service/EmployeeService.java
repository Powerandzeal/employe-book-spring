package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors ;

@Service

public class EmployeeService {

    private final Map<Integer,Employee> employees = new HashMap<>();

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


    public Employee getPersonWithMinSalary() {
        return employees.values().stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
    }



    public Employee getPersonWithMaxSalary() {
        return employees.values().stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }


    public OptionalDouble findAverageSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).average();
    }


    public Map<Integer, Employee> employeeHigherThemAverageSalary() {
        return employees
                .values()
                .stream()
                .filter(s -> s.getSalary() > findAverageSalary().getAsDouble())
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
    }
//    public List<Employee> getAllEmployeesWithAverageSalary(){
//        var averageSalary = employees.values().stream().mapToDouble(Employee::getSalary)
//                .average().orElseThrow();
//        return employees.values()
//                .stream()
//                .filter(employee -> averageSalary < employee.getSalary())
//                .collect(Collectors.toList());}

//public OptionalInt getPersonWithMaxSalary() {
//    return employees.values().stream().mapToInt(Employee::getSalary).max();
//}


//    public List<Employee> getPersonMinSalary() {
//       var min = employees.values().stream().mapToInt(Employee::getSalary).min();
//
//        return employees.values().stream().filter(employees -> min.equals(employees.getSalary()))
//                .collect(Collectors.toList());
//    }

    //    public double findAverageSalary() {
//        return (double) getSalarySum() / employees.size();
//    }



}
