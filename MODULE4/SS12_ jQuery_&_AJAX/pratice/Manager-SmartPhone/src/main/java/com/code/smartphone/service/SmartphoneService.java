package com.code.smartphone.service;

import com.code.smartphone.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();

    public Smartphone findById(Integer id);

    Smartphone save(Smartphone phone);

    Smartphone remove(Integer id);
}
