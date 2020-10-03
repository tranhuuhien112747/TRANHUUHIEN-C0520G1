package com.codegym.blog.service;

import com.codegym.blog.model.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);

    Category findById(Long id);

    void update(Long id, Category category);

    void remove(Long id);

//    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();
}
