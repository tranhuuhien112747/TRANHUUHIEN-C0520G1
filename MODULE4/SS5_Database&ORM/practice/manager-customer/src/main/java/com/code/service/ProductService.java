package com.code.service;

import com.code.model.ProductManager;

import java.util.List;

public interface ProductService {
    List<ProductManager> findAll();

    void save(ProductManager product);

    ProductManager findById(int id);

    void update(int id, ProductManager product);

    void remove(int id);
}
