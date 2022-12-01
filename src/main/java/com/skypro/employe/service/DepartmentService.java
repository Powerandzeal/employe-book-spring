package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class DepartmentService {


    EmployeeService employeeService = new EmployeeService();

    @Autowired
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final List<Employee> employeesInDepartment = new ArrayList<>();


    public Map<Integer, List<Employee>> getListEmployeeOnDepartment5(int department) {
        return employeeService
                .getAllEmployees()
                .stream()
                .filter(s -> s.getDepartment() == department)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public int getSumSalaryOnDepartment(int department) {
        return employeeService
                .getAllEmployees()
                .stream()
                .filter(s -> s.getDepartment() == department)
                .mapToInt(Employee::getSalary).sum();
    }

    public OptionalInt getMaxSalaryInDepartment(int department) {
    return employeeService
            .getAllEmployees()
            .stream()
            .filter(s->s.getDepartment()==department)
            .mapToInt(Employee::getSalary).max();
    }

    public OptionalInt getMinSalaryOnDepartment(int department) {
        return employeeService
                .getAllEmployees()
                .stream()
                .filter(s->s.getDepartment()==department)
                .mapToInt(Employee::getSalary).min();
    }


    public Map<Integer, List<Employee>> getAllEmployeeDepartment() {
        return employeeService
                .getAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<Integer, List<Employee>> getGroupedEmployeeByDepartment() {
        return employeeService
                .getAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


}
