package com.cemre.demo.service;

import com.cemre.demo.model.Employee;
import com.cemre.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);

    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }

    public List<Employee> findByUserNameContaining(String username) {
        return employeeRepository.findByUsernameContaining(username);
    }

    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);

    }

    public List<Employee> findSalaryGreaterThan(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be >0");
        }
        return employeeRepository.findSalaryGreaterThan(amount);
    }

    public List<Employee> findDepartmentByQuery(String dept) {
        if (dept==null || dept.isEmpty()) {
            throw new IllegalArgumentException(("Department cannot be null or empty"));
        }
        return employeeRepository.findDepartmentByQuery(dept);
    }
}











