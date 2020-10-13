package com.code.furamacasestudy.service;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    List<Service> finAllService();

    Service finById(String id);

    void save(Service service);

    void update(Service service);

    void remove(String id);

    Page<Service> finAllService(Pageable pageable);
}
