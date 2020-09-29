package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    void save(Category category);

    Category findById(Long id);

    void update(Long id, Category category);

    void remove(Long id);

    Page<Category> findAll(Pageable pageable);

    Iterable<Category> findAll();
}
