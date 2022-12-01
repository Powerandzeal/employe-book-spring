package com.skypro.employe;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import com.skypro.employe.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();
    EmployeeRequest employee1;
    EmployeeRequest employee2;
    EmployeeRequest employee3;
    private Map<Integer,Employee> actualEmployee;

@BeforeEach
public void setUp() {
    employee1 = new EmployeeRequest("Oleg","Nicheporenko",2,10000);
    employee2 = new EmployeeRequest("Grygory","Panshin",2,8000);
    employee3 = new EmployeeRequest("Duda","Pumkin",2,12000);

    employeeService.addEmployee(employee1);
    employeeService.addEmployee(employee2);
    employeeService.addEmployee(employee3);
}

@AfterEach
void delete() {
    employeeService = new EmployeeService();
}

@Test
    public void shouldShowEmployee() {

    Collection<Employee> actualEmployee = employeeService.getAllEmployees();
        Assertions.assertEquals(actualEmployee.size(), employeeService.getAllEmployees().size());
        Assertions.assertTrue(actualEmployee.contains(mapToEmployee(employee1)));
        Assertions.assertTrue(actualEmployee.contains(mapToEmployee(employee2)));
        Assertions.assertTrue(actualEmployee.contains(mapToEmployee(employee3)));
    }
@Test
    public void shouldShowEmployee1() {

        Assertions.assertIterableEquals((Iterable<?>) employeeService,employeeService.getAllEmployees());
    }



//    public void shouldAddEmployee() {
//
//        Assertions.assertEquals(actualEmployee,);
//    }
    private Employee mapToEmployee(EmployeeRequest request) {
        return new Employee(request.getFirstName(), request.getSecondName(),
                request.getDepartment(), request.getSalary());
    }
    public void shouldShowSalarySum() {

    }


    public void ShouldShowPersonWithMinSalary() {

    }


    public void ShouldShowPersonWithMaxSalary() {

    }


    public void ShouldFindAverageSalary() {
    }


    public void ShouldShowEmployeeHigherThemAverageSalary() {

    }


}
