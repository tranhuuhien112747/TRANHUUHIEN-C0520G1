package com.code.demo.service;

import com.code.demo.model.FormCreate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormCreateService {
    Iterable<FormCreate> findAll();

    void save(FormCreate formCreate);

    FormCreate findById(Long id);

    void update(FormCreate formCreate);

    void remove(Long id);

    Page<FormCreate> findAll(Pageable pageable);
}
