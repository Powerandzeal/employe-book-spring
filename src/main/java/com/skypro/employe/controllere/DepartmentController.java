package com.skypro.employe.controllere;

import com.skypro.employe.model.Employee;
import com.skypro.employe.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "здарова";
    }
    @GetMapping("/department/{id}/employees")
    public List showEmployeeInDepartment(@PathVariable int id) {
        return Collections.singletonList
                ("Cотрудники во  Отделе"+ id
                        + departmentService.getListEmployeeOnDepartment5(id) );
    }

    @GetMapping("/department/{id}/salary/sum")
    public String showSumSalaryInTheDepartment(@PathVariable int id) {
        return "Сумма зарплат по "+id+" Отделу "+departmentService.getSumSalaryOnDepartment(id);
    }
//
    @GetMapping("/department/{id}/salary/max")
    public OptionalInt showMaxSalaryInTheDepartment(@PathVariable int id) {
        return  departmentService.getMaxSalaryInDepartment(id);
    }

    @GetMapping("/department/{id}/salary/min")
    public OptionalInt showMinSalaryInTheDepartment(@PathVariable int id) {
        return departmentService.getMinSalaryOnDepartment(id);
    }

    @GetMapping("/department/employees")
    public Map<Integer,List<Employee>> getAllEmployeeDepartment() {
        return departmentService.getGroupedEmployeeByDepartment();
    }

//    @GetMapping("/department/{id}/employees")
//    public List<Employee> getEmployeeInDepartment(@PathVariable int id) {
//        return (List<Employee>) this.departmentService.getListEmployeeOnDepartment5(id);
//    }
}
