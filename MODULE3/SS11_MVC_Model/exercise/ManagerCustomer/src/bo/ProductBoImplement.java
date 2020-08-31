package bo;

import dao.ProductDAO;
import dao.ProductDaoImplement;
import model.Product;

import java.util.List;

public class ProductBoImplement implements ProductBo {
    private ProductDAO productDAO = new ProductDaoImplement();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public void update(String id, Product product) {
        productDAO.update(id, product);
    }

    @Override
    public void delete(String id) {
        productDAO.delete(id);
    }

    @Override
    public Product findById(String id) {
        return productDAO.findById(id);
    }
}
