package bo;

import modle.Category;
import modle.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAllProduct();

    void create(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> searchName(String name);

    List<Category> findAll();
}
