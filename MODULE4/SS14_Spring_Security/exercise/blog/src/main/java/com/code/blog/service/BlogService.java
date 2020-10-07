package com.code.blog.service;


import com.code.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService {
    Iterable<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void update(Long id, Blog blog);

    void remove(Long id);

    Page<Blog> findAll(Pageable pageable);
}
