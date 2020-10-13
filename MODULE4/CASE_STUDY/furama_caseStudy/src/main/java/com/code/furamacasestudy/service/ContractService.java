package com.code.furamacasestudy.service;

import com.code.furamacasestudy.model.Contract;
import com.code.furamacasestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> finAllContract();

    Contract finById(Long id);

    void save(Contract contract);

    void update(Contract contract);

    void remove(Long id);

    Page<Contract> finAllContract(Pageable pageable);
}
