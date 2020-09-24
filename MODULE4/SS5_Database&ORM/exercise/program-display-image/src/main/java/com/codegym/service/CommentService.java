package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> getAll();

    Comment findById(Long id);
}
