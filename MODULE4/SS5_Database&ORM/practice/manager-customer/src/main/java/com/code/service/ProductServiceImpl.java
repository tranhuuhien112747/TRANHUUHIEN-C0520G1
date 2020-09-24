package com.code.service;

import com.code.model.ProductManager;
import com.code.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public List<ProductManager> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ProductManager product) {
        repository.save(product);
    }

    @Override
    public ProductManager findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, ProductManager product) {
        repository.update(id, product);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
