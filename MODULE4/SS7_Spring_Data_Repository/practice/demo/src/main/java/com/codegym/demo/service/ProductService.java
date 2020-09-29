package com.codegym.demo.service;

import com.codegym.demo.model.ProductManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductManager> findAll();

    void save(ProductManager product);

    ProductManager findById(int id);

    void update(int id, ProductManager product);

    void remove(int id);

    Page<ProductManager> findAll(Pageable pageable);

     Page<ProductManager> findByName(String name,Pageable pageable);
}
