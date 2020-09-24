package com.codegym.repository;

import com.codegym.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
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
