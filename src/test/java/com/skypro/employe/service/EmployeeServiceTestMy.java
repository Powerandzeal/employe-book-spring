package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTestMy {

    Employee employee1;
    Employee employee2;
    EmployeeService employeeService;

    List<EmployeeRequest> spisok2 = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Boris", "Britva", 2, 1200);
        employee2 = new Employee("Lexa", "Molot", 2, 2400);

    }

    @Test
    void addEmployee() {
        Employee actual = employeeService.addEmployee
                (new EmployeeRequest("Lexa", "panin", 3, 40000));
        Employee expected = new Employee("Lexa", "panin", 3, 40000);
        assertEquals(actual, expected);
    }

    @Test
    public void addEmployee1() {
        EmployeeRequest request = new EmployeeRequest("Test", "Test", 1, 10000);
        Employee result = employeeService.addEmployee(request);
        assertEquals(request.getFirstName(), result.getFirstName());
        assertEquals(request.getSecondName(), result.getSecondName());
        assertEquals(request.getDepartment(), result.getDepartment());
        assertEquals(request.getSalary(), result.getSalary());
        Assertions.assertThat(employeeService.getAllEmployees()).contains(result);
    }


    @Test
    void getAllEmployees() {


    }


    @Test
    void getSalarySum() {
        assertEquals(3600, employeeService.getSalarySum());
    }

    @Test
    void getPersonWithMinSalary() {
    }

    @Test
    void getPersonWithMaxSalary() {
    }

    @Test
    void findAverageSalary() {
    }

    @Test
    void employeeHigherThemAverageSalary() {
    }
}