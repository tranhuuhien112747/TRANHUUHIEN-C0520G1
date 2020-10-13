package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Service;
import com.code.furamacasestudy.repository.ServiceRepository;
import com.code.furamacasestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> finAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Service finById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);

    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<Service> finAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }
}
