package com.code.repository;

import com.code.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = manager.createQuery("SELECT c FROM Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        manager.persist(blog);
    }

    @Override
    public Blog findById(int id) {
        return manager.find(Blog.class, id);
    }

    @Override
    public void update(int id, Blog blog) {
        manager.merge(blog);
    }

    @Override
    public void remove(int id) {
        manager.remove(findById(id));
    }
}
