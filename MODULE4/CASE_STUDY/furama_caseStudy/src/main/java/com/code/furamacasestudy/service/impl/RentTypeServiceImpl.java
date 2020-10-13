package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.RentType;
import com.code.furamacasestudy.repository.RentTypeRepository;
import com.code.furamacasestudy.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAllRentTypeService() {
        return rentTypeRepository.findAll();
    }
}
