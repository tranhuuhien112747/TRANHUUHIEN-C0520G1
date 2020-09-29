package com.codegym.demo.service;

import com.codegym.demo.model.ProductManager;
import com.codegym.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductManager> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(ProductManager product) {
        productRepository.save(product);
    }

    @Override
    public ProductManager findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(int id, ProductManager product) {
        productRepository.save(product);

    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductManager> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<ProductManager> findByName(String name,Pageable pageable) {
        return  productRepository.findByName(name,pageable);
    }

}
