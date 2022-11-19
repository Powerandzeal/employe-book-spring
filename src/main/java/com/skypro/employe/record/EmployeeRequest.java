package com.skypro.employe.record;

import org.springframework.util.StringUtils;

public class EmployeeRequest {
    private String firstName;
    private String secondName;
    private int department;
    private int salary;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.hasLength(firstName) && !firstName.isBlank()) {
            this.firstName = firstName;
        } else throw new RuntimeException("field is not created");
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (StringUtils.hasLength(secondName)) {
            this.secondName = secondName;
        } else throw new RuntimeException("field is not created");
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
