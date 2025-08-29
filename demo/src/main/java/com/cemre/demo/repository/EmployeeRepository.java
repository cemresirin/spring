package com.cemre.demo.repository;

import com.cemre.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByUsernameContaining(String username);
    List<Employee> findByDepartment(String department);
}
