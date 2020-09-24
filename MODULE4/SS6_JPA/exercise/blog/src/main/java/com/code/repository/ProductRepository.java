package com.code.repository;

import com.code.model.ProductManager;

import java.util.List;

public interface ProductRepository {
    List<ProductManager> findAll();

    void save(ProductManager product);

    ProductManager findById(int id);

    void update(int id, ProductManager product);

    void remove(int id);
}
