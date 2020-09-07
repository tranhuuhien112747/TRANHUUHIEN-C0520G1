package bo.customerBo;

import dao.customerDao.CustomerDAO;
import dao.customerDao.CustomerDAOImpl;
import model.Customer;

import java.util.List;

public class CustomerBoImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }

    @Override
    public void create(Customer customer) {
        customerDAO.create(customer);

    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public void delete(int id) {
        customerDAO.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> searchName(String name) {
        return customerDAO.searchName(name);
    }

    @Override
    public List<Customer> sortByName() {
        return null;
    }
}
