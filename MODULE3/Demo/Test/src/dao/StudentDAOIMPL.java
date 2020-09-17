package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOIMPL implements StudentDAO {
    private static String SELECT_ALL_STUDENT = "select *from student;";
    private static String SELECT_STUDENT_BY_ID = "select *from student where student_id = ?";
    private static String DELETE_STUDENT = "delete from student where student_id=?;";
    private static String INSERT_STUDENT = "insert into student values (?,?,?,?);";

    @Override
    public List<Student> findAllStudent() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_STUDENT);
                resultSet = statement.executeQuery();
                Student student = null;
                while (resultSet.next()) {
                    String id = resultSet.getString("student_id");
                    String name = resultSet.getString("student_name");
                    int age = resultSet.getInt("student_age");
                    String card = resultSet.getString("card_id");
                    student = new Student(id, name, age, card);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void create(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_STUDENT);
                statement.setString(1, student.getId());
                statement.setString(2, student.getName());
                statement.setInt(3, student.getAge());
                statement.setString(4, student.getCard_id());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_STUDENT);
                statement.setString(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }

        }
    }

    @Override
    public Student findById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("student_name");
                    int age = resultSet.getInt("student_age");
                    String card = resultSet.getString("card_id");
                    student = new Student(id, name, age, card);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public List<Student> searchName(String name) {
        return null;
    }

    @Override
    public boolean checkStudentIdExists(String id) {
        return false;
    }
}
