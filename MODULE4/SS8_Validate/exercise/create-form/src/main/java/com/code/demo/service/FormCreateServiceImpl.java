package com.code.demo.service;

import com.code.demo.model.FormCreate;
import com.code.demo.repository.FormCreateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormCreateServiceImpl implements FormCreateService{
    @Autowired
    FormCreateRepository formCreateRepository;

    @Override
    public Iterable<FormCreate> findAll() {
        return formCreateRepository.findAll();
    }

    @Override
    public void save(FormCreate formCreate) {
        formCreateRepository.save(formCreate);
    }

    @Override
    public FormCreate findById(Long id) {
        return null;
    }

    @Override
    public void update(FormCreate formCreate) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<FormCreate> findAll(Pageable pageable) {
        return null;
    }
}
