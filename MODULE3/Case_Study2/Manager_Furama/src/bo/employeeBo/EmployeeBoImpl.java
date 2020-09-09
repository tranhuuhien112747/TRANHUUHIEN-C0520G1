package bo.employeeBo;

import bo.checkValidate.Regex;
import dao.employeeDao.EmployeeDAO;
import dao.employeeDao.EmployeeDAOImpl;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.findAllEmployee();
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> searchName(String name) {
        return employeeDAO.searchName(name);
    }
    @Override
    public List<String> checkValidateCreateEmployee(int id, String card, String salary, String phone, String email) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateId = checkValidateEmployeeId(id);
        boolean checkValidateIdCard = Regex.checkRegexIdCard(card);
        boolean checkValidateSalary= Regex.checkRegexDoublePositive(salary);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateId && checkValidateSalary &&  checkValidateIdCard && checkValidateEmail && checkValidatePhone)) {
            if (!checkValidateId) {
                errMessList.add("ID unlike");
            } else {
                errMessList.add("");
            }
            if (!checkValidateIdCard) {
                errMessList.add("Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateSalary) {
                errMessList.add("Salary must be positive number");
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
    public List<String> checkValidateEditEmployee(String card, String salary, String phone, String email) {
        List<String> errMessList = new ArrayList<>();
        boolean checkValidateIdCard = Regex.checkRegexIdCard(card);
        boolean checkValidateSalary= Regex.checkRegexDoublePositive(salary);
        boolean checkValidatePhone = Regex.checkRegexPhoneNumber(phone);
        boolean checkValidateEmail = Regex.checkRegexEmail(email);
        if (!(checkValidateSalary &&  checkValidateIdCard && checkValidateEmail && checkValidatePhone)) {
            if (!checkValidateIdCard) {
                errMessList.add("Id Card format XXXXXXXXX (X from 0-9)");
            } else {
                errMessList.add("");
            }
            if (!checkValidateSalary) {
                errMessList.add("Salary must be positive number");
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
    private boolean checkValidateEmployeeId(int id) {
        return !employeeDAO.checkEmployeeIdExists(id);
    }
}
