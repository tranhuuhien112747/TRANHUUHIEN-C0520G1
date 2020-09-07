package dao.customerDao;

import dao.DBConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private static String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static String INSERT_CUSTOMER = "insert into customer values (?,?,?,?,?,?,?,?,?);";
    private static String SELECT_CUSTOMER_BY_ID = "select*from customer where customer_id=? ";
    private static String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id=?";
    private static final String EDIT_CUSTOMER = "UPDATE customer SET customer_type_id = ?, customer_name = ?, " +
            "customer_birthday = ?,customer_gender = ?, customer_card = ?, customer_phone = ?, customer_email = ?," +
            " customer_address = ? WHERE customer_id = ?;";
    private static String SEARCH_NAME_CUSTOMER = "select*from customer where customer_name like ?";

    @Override
    public List<Customer> findAllCustomer() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = statement.executeQuery();
                Customer customer = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date date = resultSet.getDate("customer_birthday");
                    String gender = resultSet.getString("customer_gender");
                    String card = resultSet.getString("customer_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int typeCustomer = resultSet.getInt("customer_type_id");
                    customer = new Customer(id, name, date, gender, card, phone, email, address, typeCustomer);
                    customerList.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_CUSTOMER);
                statement.setInt(1, customer.getCustomerId());
                statement.setInt(2, customer.getCustomerTypeId());
                statement.setString(3, customer.getCustomerName());
                statement.setDate(4, customer.getCustomerBirthday());
                statement.setString(5, customer.getCustomerGender());
                statement.setString(6, customer.getCustomerIdCard());
                statement.setString(7, customer.getCustomerPhone());
                statement.setString(8, customer.getCustomerEmail());
                statement.setString(9, customer.getCustomerAddress());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(EDIT_CUSTOMER);
                statement.setInt(9, customer.getCustomerId());
                statement.setInt(1, customer.getCustomerTypeId());
                statement.setString(2, customer.getCustomerName());
                statement.setDate(3, customer.getCustomerBirthday());
                statement.setString(4, customer.getCustomerGender());
                statement.setString(5, customer.getCustomerIdCard());
                statement.setString(6, customer.getCustomerPhone());
                statement.setString(7, customer.getCustomerEmail());
                statement.setString(8, customer.getCustomerAddress());
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
                statement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
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
    public Customer findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int customerType = resultSet.getInt("customer_type_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    String gender = resultSet.getString("customer_gender");
                    String card = resultSet.getString("customer_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    customer = new Customer(id, name, birthday, gender, card, phone, email, address, customerType);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return customer;
    }

    @Override
    public List<Customer> searchName(String value) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_NAME_CUSTOMER);
                statement.setString(1, "%" + value + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    String gender = resultSet.getString("customer_gender");
                    String idCard = resultSet.getString("customer_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int typeCustomerId = resultSet.getInt("customer_type_id");
                    customerList.add(new Customer(id, name, birthday, gender, idCard, phone, email, address, typeCustomerId));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> sortByName() {
        return null;
    }
}
