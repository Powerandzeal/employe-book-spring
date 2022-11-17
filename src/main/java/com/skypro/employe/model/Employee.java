package com.skypro.employe.model;

public class Employee {
    public final static int SALARY_SUM_IN_THE_MONTH = 0;
    public final static int MAX_NUM = 0;
    public final static int MIN_NUM = 1000000;
    public static int AVERAGE_SALARY;
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
