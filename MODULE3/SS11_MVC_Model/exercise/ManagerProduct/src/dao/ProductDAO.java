package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();

    void create(Product product);

    void update(String id, Product product);

    void delete(String id);

    Product findById(String id);
}
