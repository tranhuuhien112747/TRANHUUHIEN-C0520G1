package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.repository.CustomerRepository;
import com.code.furamacasestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> finAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer finById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Page<Customer> finAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
