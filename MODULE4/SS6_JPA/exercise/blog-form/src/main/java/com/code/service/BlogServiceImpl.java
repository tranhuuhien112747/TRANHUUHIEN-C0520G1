package com.code.service;

import com.code.model.Blog;
import com.code.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(int id, Blog blog) {
        blogRepository.update(id, blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }
}
