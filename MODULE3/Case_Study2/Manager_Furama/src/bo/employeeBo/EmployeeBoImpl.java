package bo.employeeBo;

import dao.employeeDao.EmployeeDAO;
import dao.employeeDao.EmployeeDAOImpl;
import model.Customer;
import model.Employee;

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
    public List<Employee> sortByName() {
        return null;
    }
}
