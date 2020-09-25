package com.code.service;

import com.code.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(int id, Blog blog);

    void remove(int id);
}
