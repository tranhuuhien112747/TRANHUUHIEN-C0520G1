package bo;

import model.Product;

import java.util.List;

public interface ProductBo {
    List<Product> findAll();

    void create(Product product);

    void update(String id, Product product);

    void delete(String id);

    Product findById(String id);
}
