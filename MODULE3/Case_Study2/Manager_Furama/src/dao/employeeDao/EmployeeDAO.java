package dao.employeeDao;

import model.Customer;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployee();

    void create(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee findById(int id);

    List<Employee> searchName(String name);

    boolean checkEmployeeIdExists(int id);
}
