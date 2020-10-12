package com.code.furamacasestudy.service;

import com.code.furamacasestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> finAllCustomer();

    Customer finById(String id);

    void save(Customer customer);

    void update(Customer customer);

    void remove(String id);

    Page<Customer> finAllCustomer(Pageable pageable);

}
