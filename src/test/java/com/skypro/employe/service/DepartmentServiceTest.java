package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    List<Employee> actualEmployee;

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Lexa", "BB", 1, 1200);
        Employee employee2 = new Employee("Vova", "Tesfdfdt", 3, 3000);
        Employee employee3 = new Employee("Sergey", "Teewwst", 1, 5000);

        actualEmployee =  List.of(employee1, employee2, employee3);
    }



    @Test
    void getListEmployeeOnDepartment5() {
        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
        final int department = 1;
         List<Employee> actual = actualEmployee.stream().filter(employee -> employee.getDepartment() == department).
                collect(Collectors.toList());
         Map<Integer, List<Employee>> expected = departmentService.getListEmployeeOnDepartment5(1);
        assertEquals(expected, actual);

    }

    @Test
    void getSumSalaryOnDepartment() {
    }

    @Test
    void getMaxSalaryInDepartment() {

    }

    @Test
    void getMinSalaryOnDepartment() {
    }

    @Test
    void getAllEmployeeDepartment() {
    }

    @Test
    void getGroupedEmployeeByDepartment() {
    }
}