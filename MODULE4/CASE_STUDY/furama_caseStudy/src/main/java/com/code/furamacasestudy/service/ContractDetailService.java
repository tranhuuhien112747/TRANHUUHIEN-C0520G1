package com.code.furamacasestudy.service;

import com.code.furamacasestudy.model.ContractDetail;
import com.code.furamacasestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> finAllContractDetail();

    ContractDetail finById(Long id);

    void save(ContractDetail contractDetail);

    void update(ContractDetail contractDetail);

    void remove(Long id);

    Page<ContractDetail> finAllService(Pageable pageable);
}
