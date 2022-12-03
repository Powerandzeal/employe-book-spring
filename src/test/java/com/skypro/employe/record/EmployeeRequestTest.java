package com.skypro.employe.record;

import com.skypro.employe.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRequestTest {

    EmployeeRequest employeeRequest;
    EmployeeRequest employeeRequest1;
    @BeforeEach
    void setUp() {
        employeeRequest = new EmployeeRequest("Boris","Britva",1,40000);
        employeeRequest1 = new EmployeeRequest("Aleksandr","White",2,90000);
    }

    @Test
    void getFirstName() {
        assertEquals("Boris",employeeRequest.getFirstName());
        assertEquals("Aleksandr",employeeRequest1.getFirstName());
    }

    @Test
    void setFirstName() {
    employeeRequest.setFirstName("Grigory");
    assertEquals("Grigory",employeeRequest.getFirstName());

    }

    @Test
    void getSecondName() {
        assertEquals("Britva",employeeRequest.getSecondName());
        assertEquals("White",employeeRequest1.getSecondName());
    }

    @Test
    void setSecondName() {
        employeeRequest1.setSecondName("Molot");
        assertEquals("Molot",employeeRequest1.getSecondName());
    }

    @Test
    void getDepartment() {
        assertEquals(1,employeeRequest.getDepartment());
        assertEquals(2,employeeRequest1.getDepartment());
    }

    @Test
    void setDepartment() {
        employeeRequest.setDepartment(3);
        assertEquals(3,employeeRequest.getDepartment());
    }

    @Test
    void getSalary() {
        assertEquals(40000,employeeRequest.getSalary());
        assertEquals(90000,employeeRequest1.getSalary());
    }

    @Test
    void setSalary() {
        employeeRequest.setSalary(120000);
        assertEquals(120000,employeeRequest.getSalary());
    }
}