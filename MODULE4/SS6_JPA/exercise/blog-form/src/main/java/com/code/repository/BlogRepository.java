package com.code.repository;

import com.code.model.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(int id, Blog blog);

    void remove(int id);
}
