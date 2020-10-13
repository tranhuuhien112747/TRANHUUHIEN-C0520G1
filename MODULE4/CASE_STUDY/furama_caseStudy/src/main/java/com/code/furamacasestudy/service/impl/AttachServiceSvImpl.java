package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.AttachService;
import com.code.furamacasestudy.repository.AttachServiceRepository;
import com.code.furamacasestudy.service.AttachServiceSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceSvImpl implements AttachServiceSv {
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }
}
