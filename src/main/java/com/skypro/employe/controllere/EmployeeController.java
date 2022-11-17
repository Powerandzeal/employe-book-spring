package com.skypro.employe.controllere;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import com.skypro.employe.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public Collection<Employee> getAllEmployee() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest ) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employee/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min")
    public OptionalInt getMin() {
        return this.employeeService.getMinSalary();
    }

    @GetMapping("/employee/salary/max")
    public OptionalInt getMinAndMax() {
        return this.employeeService.getMaxSalary();
    }

    @GetMapping("/employee/employeeHigherThemAverageSalary")
    public Map<Integer, Employee> employeeHigherThemAverageSalary() {
        return this.employeeService.employeeHigherThemAverageSalary();
    }

    @GetMapping("/employee/findAverageSalary")
    public double findAverageSalary() {
        return this.employeeService.findAverageSalary();
    }
}
