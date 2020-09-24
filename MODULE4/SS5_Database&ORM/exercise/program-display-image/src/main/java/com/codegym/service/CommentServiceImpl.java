package com.codegym.service;

import com.codegym.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public void save(Comment comment) {

    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }
}
