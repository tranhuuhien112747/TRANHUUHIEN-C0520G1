package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.CustomerType;
import com.code.furamacasestudy.repository.CustomerTypeRepository;
import com.code.furamacasestudy.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
