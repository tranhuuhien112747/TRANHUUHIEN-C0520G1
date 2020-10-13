package com.code.furamacasestudy.service.impl;

import com.code.furamacasestudy.model.ContractDetail;
import com.code.furamacasestudy.repository.ContractDetailRepository;
import com.code.furamacasestudy.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> finAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail finById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);

    }

    @Override
    public void update(ContractDetail contractDetail) {
contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
contractDetailRepository.deleteById(id);
    }

    @Override
    public Page<ContractDetail> finAllService(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }
}
