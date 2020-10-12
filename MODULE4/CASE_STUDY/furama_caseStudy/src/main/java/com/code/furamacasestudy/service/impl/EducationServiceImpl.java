package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Education;
import com.code.furamacasestudy.repository.EducationRepository;
import com.code.furamacasestudy.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;
    @Override
    public List<Education> findAllEducation() {
        return educationRepository.findAll();
    }
}
