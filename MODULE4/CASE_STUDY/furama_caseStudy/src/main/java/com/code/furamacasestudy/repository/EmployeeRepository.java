package com.code.furamacasestudy.repository;

import com.code.furamacasestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Page<Employee> findEmployeeByEmployeeIdContainingOrEmployeeNameContaining(String id , String name, Pageable pageable);
}
