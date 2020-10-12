package com.code.furamacasestudy.repository;

import com.code.furamacasestudy.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
