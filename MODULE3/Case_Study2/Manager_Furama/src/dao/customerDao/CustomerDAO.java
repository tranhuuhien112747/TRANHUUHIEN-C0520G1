package dao.customerDao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAllCustomer();

    void create(Customer customer);

    void update(Customer customer);

    void delete(String id);

    Customer findById(String id);

    List<Customer> searchName(String name);

    List<Customer> sortByName();
}
