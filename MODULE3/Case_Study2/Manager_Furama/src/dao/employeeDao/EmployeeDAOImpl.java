package dao.employeeDao;

import dao.DBConnection;
import model.Customer;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static String SELECT_ALL_EMPLOYEE = "select * from employee;";
    private static String INSERT_EMPLOYEE = "insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static String SELECT_EMPLOYEE_BY_ID = "select*from employee where employee_id=? ";
    private static String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id=?";
    private static String UPDATE_EMPLOYEE = "update employee set employee_name = ?,employee_birthday = ?, " +
            "employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_adress = ? ," +
            "position_id = ?, division_id = ?, education_degree_id = ? where employee_id=?;";
    private static String SEARCH_NAME_EMPLOYEE = "select*from employee where employee_name like ?";
    private static final String CHECK_EMPLOYEE_ID_EXISTS = "SELECT 1 FROM employee WHERE employee_id = ?;";
    @Override
    public List<Employee> findAllEmployee() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                Employee employee = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    String date = resultSet.getString("employee_birthday");
                    String card = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_adress");
                    int posittion = resultSet.getInt("position_id");
                    int division = resultSet.getInt("division_id");
                    int education = resultSet.getInt("education_degree_id");
                    String userName = resultSet.getString("username");
                    employee = new Employee(id, name, date, card, salary, phone, email, address, posittion, division, education, userName);
                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_EMPLOYEE);
                statement.setInt(1, employee.getEmployeeId());
                statement.setString(2, employee.getEmployeeName());
                statement.setString(3, employee.getEmployeeBirthday());
                statement.setString(4, employee.getEmployeeIdCard());
                statement.setDouble(5, employee.getEmployeeSalary());
                statement.setString(6, employee.getEmployeePhone());
                statement.setString(7, employee.getEmployeeEmail());
                statement.setString(8, employee.getEmployeeAddress());
                statement.setInt(9, employee.getEmployeePosition());
                statement.setInt(10, employee.getEmployeeDivision());
                statement.setInt(11, employee.getEmployeeEducation());
                statement.setString(12, employee.getUserName());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setInt(11, employee.getEmployeeId());
                statement.setString(1, employee.getEmployeeName());
                statement.setString(2, employee.getEmployeeBirthday());
                statement.setString(3, employee.getEmployeeIdCard());
                statement.setDouble(4, employee.getEmployeeSalary());
                statement.setString(5, employee.getEmployeePhone());
                statement.setString(6, employee.getEmployeeEmail());
                statement.setString(7, employee.getEmployeeAddress());
                statement.setInt(8, employee.getEmployeePosition());
                statement.setInt(9, employee.getEmployeeDivision());
                statement.setInt(10, employee.getEmployeeEducation());
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
                statement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
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
    public Employee findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("employee_name");
                    String date = resultSet.getString("employee_birthday");
                    String card = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_adress");
                    int posittion = resultSet.getInt("position_id");
                    int division = resultSet.getInt("division_id");
                    int education = resultSet.getInt("education_degree_id");
                    String userName = resultSet.getString("username");
                    employee = new Employee(id, name, date, card, salary, phone, email, address, posittion, division, education, userName);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> searchName(String value) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_NAME_EMPLOYEE);
                statement.setString(1, "%" + value + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    String date = resultSet.getString("employee_birthday");
                    String card = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_adress");
                    int position = resultSet.getInt("position_id");
                    int division = resultSet.getInt("division_id");
                    int education = resultSet.getInt("education_degree_id");
                    String userName = resultSet.getString("username");
                    employee = new Employee(id, name, date, card, salary, phone, email, address, position, division, education, userName);
                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return employeeList;
    }

    @Override
    public boolean checkEmployeeIdExists(int id){
        boolean checkExists = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CHECK_EMPLOYEE_ID_EXISTS);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    checkExists = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return checkExists;
    }
}
