package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void update(Long id, Blog blog);

    void remove(Long id);

//    Page<Blog> findAll(Pageable pageable);
}
