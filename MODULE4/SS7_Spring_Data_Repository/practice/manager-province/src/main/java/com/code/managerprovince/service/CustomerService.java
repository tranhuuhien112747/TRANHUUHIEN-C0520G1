package com.code.managerprovince.service;

import com.code.managerprovince.model.Customer;
import com.code.managerprovince.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
}
