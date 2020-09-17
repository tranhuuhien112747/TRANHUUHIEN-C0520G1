package dao;

import modle.Category;
import modle.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static String SELECT_ALL_PRODUCT = "select * from product;";
    private static String SELECT_BY_ID = "select * from product where product_id=?";

    private static String DELETE_PRODUCT="delete from product where product_id=?";
    private static String INSERT_PRODUCT="insert into product values (?,?,?,?,?,?,?);";
    private static String SEARCH_NAME= "select*from product where product_name like ?";
    private static String UPDATE_PRODUCT="update product set product_name=?, price=?,quantity=?,color=?,description_other=?,category_id=?\n" +
            "where product_id=?;";
    @Override
    public List<Product> findAllProduct() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = statement.executeQuery();
                Product product = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description_other");
                    int  category = resultSet.getInt("category_id");
                    product = new Product(id, name, price, quantity, color, description, category);
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_PRODUCT);
                statement.setInt(1,product.getId());
                statement.setString(2, product.getName());
               statement.setDouble(3,product.getPrice());
               statement.setInt(4,product.getQuantity());
               statement.setString(5,product.getColor());
                statement.setString(6, product.getDescription());
                statement.setInt(7,product.getCategory());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_PRODUCT);
                statement.setInt(7,product.getId());
                statement.setString(1, product.getName());
                statement.setDouble(2,product.getPrice());
                statement.setInt(3,product.getQuantity());
                statement.setString(4,product.getColor());
                statement.setString(5, product.getDescription());
                statement.setInt(6,product.getCategory());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_PRODUCT);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }

        }
    }

    @Override
    public Product findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description_other");
                    int category  = resultSet.getInt("category_id");
                    product = new Product(id, name, price, quantity, color, description, category);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public List<Product> searchName(String value) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_NAME);
                statement.setString(1,  "%"+ value + "%");
                resultSet = statement.executeQuery();
                Product product = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String name = resultSet.getString("product_name");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description_other");
                    int  category = resultSet.getInt("category_id");
                    product = new Product(id, name, price, quantity, color, description, category);
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return productList;
    }

}

