package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Position;
import com.code.furamacasestudy.repository.PositionRepository;
import com.code.furamacasestudy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}
