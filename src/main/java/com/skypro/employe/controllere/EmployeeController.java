package com.skypro.employe.controllere;

import com.skypro.employe.model.Employee;
import com.skypro.employe.record.EmployeeRequest;
import com.skypro.employe.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public Collection<Employee> getAllEmployee() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest ) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employee/salary/sum" )
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min")
    public Employee getMin() {
        return this.employeeService.getPersonWithMinSalary();
    }

    @GetMapping("/employee/salary/max")
    public Employee getMinAndMax() {
        return this.employeeService.getPersonWithMaxSalary();
    }

    @GetMapping("/employee/employeeHigherThemAverageSalary")
    public List <Employee> employeeHigherThemAverageSalary() {
        return this.employeeService.employeeHigherThemAverageSalaryTry();
    }

//    @GetMapping("/employee/employeeHigherThemAverageSalary")
//    public Map<Integer, Employee> employeeHigherThemAverageSalary() {   Origina потом подставить обратно если не выйдет
//        return this.employeeService.employeeHigherThemAverageSalary();
//    }

    @GetMapping("/employee/findAverageSalary")
    public double findAverageSalary() {
        return this.employeeService.findAverageSalary().getAsDouble();
    }

//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public class ServiceException extends Exception {
//        public ServiceException(String message) {
//            super(message);
//        }
//
//    }

//    @GetMapping("employee/methodlevel")
//    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found on the server")
//    public String notFound() {
//        return "";
//    }
}
