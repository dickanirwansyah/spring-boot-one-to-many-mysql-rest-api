package com.spring.app.springbootangularcore.repository;

import com.spring.app.springbootangularcore.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
