package com.cemre.demo.repository;

import com.cemre.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByUsernameContaining(String username);
    List<Employee> findByDepartment(String department);

    @Query ("SELECT e FROM Employee e WHERE e.salary > :amount")
    List<Employee> findSalaryGreaterThan(@Param("amount") double amount);

    @Query (value = "SELECT * FROM employees WHERE department = :dept", nativeQuery = true)
    List<Employee> findDepartmentByQuery(@Param("dept") String dept);

}
