package bo;

import dao.DBConnection;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import modle.Category;
import modle.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO = new ProductDAOImpl();
    private static String SELECT_ALL_CATEGORY = "select * from category;";

    @Override
    public List<Product> findAllProduct() {
        return productDAO.findAllProduct();
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> searchName(String name) {
        return productDAO.searchName(name);
    }

    @Override
    public List<Category> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Category> categoryList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CATEGORY);
                resultSet = statement.executeQuery();
                Category category = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("category_id");
                    String name = resultSet.getString("category_name");
                    category = new Category(id, name);
                    categoryList.add(category);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return categoryList;
    }
}
