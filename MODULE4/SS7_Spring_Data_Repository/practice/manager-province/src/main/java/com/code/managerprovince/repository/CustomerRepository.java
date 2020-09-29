package com.code.managerprovince.repository;

import com.code.managerprovince.model.Customer;
import com.code.managerprovince.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
