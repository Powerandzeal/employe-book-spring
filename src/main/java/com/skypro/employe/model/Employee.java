package com.skypro.employe.model;

import com.skypro.employe.controllere.EmployeeController;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Employee {

    private static int counter;

    private final int id;

    private final String firstName;

    private final String secondName;

    private final int department;

    private final double salary;

    public Employee(String firstName, String secondName, int department, double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary ;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName ;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return (int) salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "counter=" + counter +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }


}
