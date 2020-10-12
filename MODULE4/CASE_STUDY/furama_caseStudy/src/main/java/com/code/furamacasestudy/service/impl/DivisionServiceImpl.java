package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Division;
import com.code.furamacasestudy.repository.DivisionRepository;
import com.code.furamacasestudy.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
