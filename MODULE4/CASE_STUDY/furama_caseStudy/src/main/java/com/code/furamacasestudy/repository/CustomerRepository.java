package com.code.furamacasestudy.repository;

import com.code.furamacasestudy.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
