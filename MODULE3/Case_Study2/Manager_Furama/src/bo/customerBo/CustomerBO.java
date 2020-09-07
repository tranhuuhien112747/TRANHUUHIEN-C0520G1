package bo.customerBo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAllCustomer();

    void create(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Customer findById(int id);

    List<Customer> searchName(String name);

    List<Customer> sortByName();
}
