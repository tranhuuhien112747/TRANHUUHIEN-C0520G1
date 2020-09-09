package bo.customerBo;

import bo.checkValidate.Regex;
import dao.customerDao.CustomerDAO;
import dao.customerDao.CustomerDAOImpl;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBO {
    public static final String REGEX_ID_CUSTOMER = "^(KH-\\d{4})$";
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
    public void delete(String id) {
        customerDAO.delete(id);
    }

    @Override
    public Customer findById(String id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> searchName(String name) {
        return customerDAO.searchName(name);
    }

    @Override
    public List<String> checkValidateCreateCustomer(String id, String card, String phone, String email) {
        List<String> errMessList = new ArrayList<>(4);
        boolean checkValidateId = checkValidateCustomerId(id);
        boolean checkValidateIdCard = Regex.checkRegexIdCard(card);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateId && checkValidateIdCard && checkValidateEmail && checkValidatePhone)) {
            if (!checkValidateId) {
                errMessList.add("ID format KH-XXXX (X from 0-9) and unlike");
            } else {
                errMessList.add("");
            }
            if (!checkValidateIdCard) {
                errMessList.add("Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidatePhone) {
                errMessList.add("Phone number is not in the correct format");
            } else {
                errMessList.add("");
            }
            if (!checkValidateEmail) {
                errMessList.add("Email format abc@abc.abc");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }

    @Override
    public List<String> checkValidateEditCustomer(String card, String phone, String email) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateIdCard = Regex.checkRegexIdCard(card);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateIdCard && checkValidateEmail && checkValidatePhone)) {
            if (!checkValidateIdCard) {
                errMessList.add("ID format KH-XXXX (X from 0-9) and unlike");
            } else {
                errMessList.add("");
            }
            if (!checkValidatePhone) {
                errMessList.add("Phone number is not in the correct format");
            } else {
                errMessList.add("");
            }
            if (!checkValidateEmail) {
                errMessList.add("Email format abc@abc.abc");
            } else {
                errMessList.add("");
            }
        }
        return errMessList;
    }

    private boolean checkValidateCustomerId(String id) {
        return !customerDAO.checkCustomerIdExists(id) && Regex.checkRegex(REGEX_ID_CUSTOMER, id);
    }
}
