package dao;

import modle.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAllProduct();

    void create(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> searchName(String name);

}
