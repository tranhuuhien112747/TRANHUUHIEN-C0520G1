package com.code.furamacasestudy.service;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> finAllEmployee();

    Employee finById(String id);

    void save(Employee employee);

    void update(Employee employee);

    void remove(String id);

    Page<Employee> finAllEmployee(Pageable pageable);
}
