package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Employee;
import com.code.furamacasestudy.repository.EmployeeRepository;
import com.code.furamacasestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> finAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee finById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void remove(String id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Page<Employee> finAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
