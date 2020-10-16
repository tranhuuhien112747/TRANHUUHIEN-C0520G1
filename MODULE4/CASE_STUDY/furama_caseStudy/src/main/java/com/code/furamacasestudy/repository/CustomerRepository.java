package com.code.furamacasestudy.repository;

import com.code.furamacasestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findCustomerByCustomerIdContainingOrCustomerNameContaining(String id, String name, Pageable pageable);
    Page<Customer> findCustomerByCustomerBirthdayContaining(String day,Pageable pageable);
    Page<Customer> findCustomerByCustomerTypeCustomerTypeName(String type,Pageable pageable);
    Page<Customer> findAllByStatusTrue(Pageable pageable);
    void deleteAllByCustomerIdIn(List<String> list);

}
