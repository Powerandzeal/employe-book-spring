package com.skypro.employe.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    static Employee employee;
    static Employee employee1;
    @BeforeAll
    static void setUp() {
         employee = new Employee("Boris","Britva",1,40000);
         employee1 = new Employee("Aleksandr","White",1,90000);
    }

    @Test
    void ShouldReturnId() {
        assertEquals(0,employee.getId());
        assertEquals(1,employee1.getId());
    }
    @Test
    void ShouldGetFirstName() {
        assertEquals("Boris",employee.getFirstName());
        assertEquals("Aleksandr",employee1.getFirstName());
    }

    @Test
    void TestGetSecondName() {
        assertEquals("Britva",employee.getSecondName());
        assertEquals("White",employee1.getSecondName());
    }

    @Test
    void TestGetDepartment() {
        assertEquals(1,employee.getDepartment());
        assertEquals(1,employee1.getDepartment());
    }

    @Test
    void testGetSalary() {
        assertEquals(40000,employee.getSalary());
        assertEquals(90000,employee1.getSalary());
    }
}