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
import java.util.OptionalDouble;
import java.util.OptionalInt;
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

        final int department = 1;
         Map<Integer,List<Employee>> actual = actualEmployee.stream().filter(employee -> employee.getDepartment() == department).
                collect(Collectors.toList());
        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
         Map<Integer,List<Employee>> expected = departmentService.getListEmployeeOnDepartment5(1);
        assertEquals(expected, actual);

    }

    @Test
    void getSumSalaryOnDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
        final int department = 1;
        final int actual = (int) actualEmployee.stream().filter(employee -> employee.getDepartment() == department).
                mapToDouble(Employee::getSalary).sum();
        final int expected = departmentService.getSumSalaryOnDepartment(department);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getMaxSalaryInDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
        final int department = 1;
         OptionalInt actual = OptionalInt.of(actualEmployee.stream().filter(employee -> employee.getDepartment() == department).
                mapToInt(Employee::getSalary).max().orElseThrow(RuntimeException::new));
         OptionalInt expected = departmentService.getMaxSalaryInDepartment(department);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getMinSalaryOnDepartment() {
            when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
            final int department = 1;
            final OptionalInt actual = OptionalInt.of(actualEmployee.stream().filter(employee -> employee.getDepartment() == department).
                    mapToInt(Employee::getSalary).min().orElseThrow(RuntimeException::new));
            final OptionalInt expected = departmentService.getMinSalaryOnDepartment(department);
            Assertions.assertEquals(expected, actual);
    }


    @Test
    void getGroupedEmployeeByDepartment() {

        when(employeeService.getAllEmployees()).thenReturn(actualEmployee);
        final Map<Integer, List<Employee>> actual = employeeService.getAllEmployees().stream().collect(Collectors.
                groupingBy(Employee::getDepartment));
        final Map<Integer, List<Employee>> expected = departmentService.getGroupedEmployeeByDepartment();
        Assertions.assertEquals(expected, actual);
    }
}