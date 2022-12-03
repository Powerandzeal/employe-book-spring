package com.skypro.employe.service;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import com.skypro.employe.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();

//    private Map<Integer, Employee> actualEmployee;

//@BeforeEach
//public void setUp() {
////    employee1 = new EmployeeRequest("Oleg","Nicheporenko",2,10000);
////    employee2 = new EmployeeRequest("Grygory","Panshin",2,8000);
////    employee3 = new EmployeeRequest("Duda","Pumkin",2,12000);
//
//    employeeService.addEmployee(employee1);
//    employeeService.addEmployee(employee2);
//    employeeService.addEmployee(employee3);
//}


    @Test
    public void addEmployee() {
        EmployeeRequest actual = new EmployeeRequest("Test", "Test", 1, 10000);

        Employee result = employeeService.addEmployee(actual);

        assertEquals(actual.getFirstName(), result.getFirstName());
        assertEquals(actual.getSecondName(), result.getSecondName());
        assertEquals(actual.getDepartment(), result.getDepartment());
        assertEquals(actual.getSalary(), result.getSalary());

        org.assertj.core.api.Assertions.assertThat(employeeService.getAllEmployees()).contains(result);
    }

    @Test
    public void getAllEmployeeTest() {
        EmployeeRequest employee0 = new EmployeeRequest("Vlad",
                "test", 2, 1000);

        EmployeeRequest employee1 = new EmployeeRequest("Igor",
                "Test", 2, 1500);

        EmployeeRequest employee2 = new EmployeeRequest("Nikita",
                "Test", 2, 2000);

        Employee h1 = employeeService.addEmployee(employee0);
        Employee h2 = employeeService.addEmployee(employee1);
        Employee h3 = employeeService.addEmployee(employee2);
//

        Collection<Employee> expected = employeeService.getAllEmployees().stream().toList();
        Collection<Employee> actual = new ArrayList<>();
        actual.add(h1);
        actual.add(h2);
        actual.add(h3);

        assertEquals(expected, actual);


    }


    @Test
    public void shouldShowSalarySum() {
        EmployeeRequest minSalaryEmployeeRq = new EmployeeRequest("Test",
                "Test", 2, 1000);

        EmployeeRequest employee1 = new EmployeeRequest("Test",
                "Test", 2, 1500);

        EmployeeRequest employee2 = new EmployeeRequest("Test",
                "Test", 2, 2000);

        employeeService.addEmployee(minSalaryEmployeeRq);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);


        assertEquals(4500, employeeService.getSalarySum());

    }


    @Test
    public void shouldReturnPersonWithMinSalary() {
        EmployeeRequest minSalaryEmployeeRq = new EmployeeRequest("Test",
                "Test", 2, 1);

        EmployeeRequest employee1 = new EmployeeRequest("Test",
                "Test", 2, 100);

        EmployeeRequest employee2 = new EmployeeRequest("Test",
                "Test", 2, 2);

        Employee minSalaryEmployee = employeeService.addEmployee(minSalaryEmployeeRq);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        assertEquals(minSalaryEmployee, employeeService.getPersonWithMinSalary());

    }

    @Test
    public void ShouldShowPersonWithMaxSalary() {

        EmployeeRequest maxSalaryEmployeeRq = new EmployeeRequest("Test",
                "Test", 2, 2000);

        EmployeeRequest employee1 = new EmployeeRequest("Test",
                "Test", 2, 1000);

        EmployeeRequest employee2 = new EmployeeRequest("Test",
                "Test", 2, 1500);
        Employee maxSalaryEmployee = employeeService.addEmployee(maxSalaryEmployeeRq);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        assertEquals(maxSalaryEmployee, employeeService.getPersonWithMaxSalary());
    }

    @Test
    public void ShouldFindAverageSalary() {

        EmployeeRequest employee1 = new EmployeeRequest("Test",
                "Test", 2, 1000);

        EmployeeRequest employee2 = new EmployeeRequest("Test",
                "Test", 2, 1500);
        OptionalDouble expectedAverageEmployee = OptionalDouble.of(1250);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        assertEquals(expectedAverageEmployee, employeeService.findAverageSalary());


    }

    @Test
    public void ShouldShowEmployeeHigherThemAverageSalary() {

        List<Employee> higherThemAveraageSalary = new ArrayList<>();
        EmployeeRequest employeeWithHigherSalaryRq = new EmployeeRequest("Dmitry",
                "Obama", 3, 5000);

        EmployeeRequest employee3 = new EmployeeRequest("Dmitry",
                "Obama", 3, 4300);

        EmployeeRequest employee1 = new EmployeeRequest("Test",
                "Test", 2, 1000);

        EmployeeRequest employee2 = new EmployeeRequest("Test",
                "Test", 2, 1500);

        Employee hihger = employeeService.addEmployee(employeeWithHigherSalaryRq);
        Employee hihger1 = employeeService.addEmployee(employee3);
        higherThemAveraageSalary.add(hihger);
        higherThemAveraageSalary.add(hihger1);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        assertEquals(higherThemAveraageSalary, employeeService.employeeHigherThemAverageSalaryTry());

    }




    //    @Test
//    public void shouldShowEmployee() {
//
//        Collection<Employee> actualEmployee = employeeService.getAllEmployees();
//        assertEquals(actualEmployee.size(), employeeService.getAllEmployees().size());
//        Assertions.assertTrue(actualEmployee.contains(mapToEmployee(employee1)));
//        Assertions.assertTrue(actualEmployee.contains(mapToEmployee(employee2)));
//        Assertions.assertTrue(actualEmployee.contains(mapToEmployee(employee3)));
//    }

//    @Test
//    public void shouldShowEmployee1() {
//
//        Assertions.assertIterableEquals((Iterable<?>) employeeService, employeeService.getAllEmployees());
//    }


//    private Employee mapToEmployee(EmployeeRequest request) {
//        return new Employee(request.getFirstName(), request.getSecondName(),
//                request.getDepartment(), request.getSalary());
//    }


}
