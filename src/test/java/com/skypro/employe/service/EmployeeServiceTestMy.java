package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTestMy {

    Employee employee1;

   List<EmployeeRequest> spisok2 = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Boris", "Britva", 2, 12);

    }

    @Test
    void addEmployee() {

    }


    @Test
    void getAllEmployees() {


    }


    @Test
    void getSalarySum() {
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