package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.Contract;
import com.code.furamacasestudy.repository.ContractRepository;
import com.code.furamacasestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> finAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Contract finById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> finAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
