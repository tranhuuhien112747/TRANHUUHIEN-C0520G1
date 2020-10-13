package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.ServiceType;
import com.code.furamacasestudy.repository.ServiceTypeRepository;
import com.code.furamacasestudy.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }
}
