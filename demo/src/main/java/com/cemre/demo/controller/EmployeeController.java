package com.cemre.demo.controller;

import com.cemre.demo.model.Employee;
import com.cemre.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @PostMapping(path = "/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/username/{username}")
    public List<Employee> findByUsernameContaining(@PathVariable("username") String username) {
        return employeeService.findByUserNameContaining(username);

    }

    @GetMapping("/department/{department}")
    public List<Employee> findByDepartment(@PathVariable("department") String department){
        return employeeService.findByDepartment(department);

    }

    @GetMapping("/salary")
    public List<Employee> findSalaryGreaterThan(@RequestParam(value = "amount") double amount) {
        return employeeService.findSalaryGreaterThan(amount);
    }

    @GetMapping("/department")
    public List<Employee>findDepartmentByQuery(@RequestParam(value = "department") String dept) {
        return employeeService.findDepartmentByQuery(dept);
    }
}


















