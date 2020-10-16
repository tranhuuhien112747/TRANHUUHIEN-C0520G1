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
        customer.setStatus(true);
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(String id) {
        Customer customer=customerRepository.findById(id).orElse(null);
        customer.setStatus(false);
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> finAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByIdAndName(String inputSearch, Pageable pageable) {
        return customerRepository.findCustomerByCustomerIdContainingOrCustomerNameContaining(inputSearch, inputSearch, pageable);
    }

    @Override
    public Page<Customer> findCustomerByCustomerBirthdayContaining(String day, Pageable pageable) {
        return customerRepository.findCustomerByCustomerBirthdayContaining(day, pageable);
    }

    @Override
    public Page<Customer> findCustomerByCustomerTypeContaining(String type, Pageable pageable) {
        return customerRepository.findCustomerByCustomerTypeCustomerTypeName(type, pageable);
    }

    @Override
    public Page<Customer> findAllByStatusTrue(Pageable pageable) {
        return customerRepository.findAllByStatusTrue(pageable);
    }

    @Override
    public void deleteAllByCustomerIdIn(List<String> list) {
        for (String id:list){
            Customer customer=customerRepository.findById(id).orElse(null);
            customer.setStatus(false);
            customerRepository.save(customer);
        }
    }


}
