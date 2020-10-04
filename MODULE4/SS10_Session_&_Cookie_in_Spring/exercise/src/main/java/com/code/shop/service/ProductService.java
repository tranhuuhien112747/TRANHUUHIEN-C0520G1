package com.code.shop.service;

import com.code.shop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);
}
