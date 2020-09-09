package bo.customerBo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAllCustomer();

    void create(Customer customer);

    void update(Customer customer);

    void delete(String id);

    Customer findById(String id);

    List<Customer> searchName(String name);

    List<String> checkValidateCreateCustomer(String id, String card, String phone, String email,String birthday);

    List<String> checkValidateEditCustomer(String card, String phone, String email,String birthday);
}
