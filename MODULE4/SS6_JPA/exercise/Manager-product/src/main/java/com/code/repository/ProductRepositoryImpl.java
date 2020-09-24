package com.code.repository;

import com.code.model.ProductManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<ProductManager> findAll() {
        TypedQuery<ProductManager> query = em.createQuery("select c from ProductManager c", ProductManager.class);
        return query.getResultList();
    }

    @Override
    public void save(ProductManager product) {
        em.persist(product);
    }

    @Override
    public ProductManager findById(int id) {
        return em.find(ProductManager.class, id);
    }

    @Override
    public void update(int id, ProductManager product) {
        em.merge(product);

    }

    @Override
    public void remove(int id) {
        em.remove(findById(id));

    }
}
