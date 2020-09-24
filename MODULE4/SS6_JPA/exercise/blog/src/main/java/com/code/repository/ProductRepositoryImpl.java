package com.code.repository;

import com.code.model.ProductManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, ProductManager> productList;

//    static {
//        productList = new TreeMap<>();
//        productList.put(1, new ProductManager(1, "SP-1", "IphoneX", 5000, "Apple"));
//        productList.put(2, new ProductManager(2, "SP-2", "SamSung S9-Pro", 5000, "SamSung"));
//        productList.put(3, new ProductManager(3, "SP-3", "Oppo Reno-3", 5000, "Oppo"));
//        productList.put(4, new ProductManager(4, "SP-4", "Nokia A9", 5000, "Nokia"));
//        productList.put(5, new ProductManager(5, "SP-5", "Xiaomi-real7", 5000, "Xiaomi"));
//    }

    @Override
    public List<ProductManager> findAll() {
        Session session = null;
        List<ProductManager> productList = null;
        try {
            session = Connection.sessionFactory.openSession();
            productList = session.createQuery("from ProductManager").getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(ProductManager product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Connection.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ProductManager findById(int id) {
        Session session = null;
        ProductManager product = null;
        try {
            session = Connection.sessionFactory.openSession();

            product = session.get(ProductManager.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(int id, ProductManager product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Connection.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Connection.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(findById(id));
           // productList.remove(id);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
