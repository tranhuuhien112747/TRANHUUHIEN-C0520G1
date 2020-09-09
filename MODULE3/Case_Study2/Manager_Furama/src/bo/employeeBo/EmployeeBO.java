package bo.employeeBo;

import model.Customer;
import model.Employee;

import java.util.List;

public interface EmployeeBO {
    List<Employee> findAllEmployee();

    void create(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee findById(int id);

    List<Employee> searchName(String name);

    List<String> checkValidateCreateEmployee(int id, String card, String salary, String phone, String email);

    List<String> checkValidateEditEmployee(String card, String salary, String phone, String email);
}
