package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String INSERT_NEW_STUDENT = "INSERT INTO  student(name, address) VALUE (?, ?);";
    private static final String GET_STUDENT_BY_ID = "call get_student_by_id(?)";
    private static final String UPDATE_STUDENT_BY_ID = "call update_student_by_id(?,?,?);";
    private static final String UPDATE_MONEY_WHERE_ID = "update student set money = (money + ?) where id = ?";

    @Override
    public List<Student> findAll() {
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
                    student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAddress(resultSet.getString("address"));
                    student.setMoney(resultSet.getLong("money"));
                    studentList.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_STUDENT);
                statement.setString(1, student.getName());
                statement.setString(2, student.getAddress());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        Student student = null;

        if (connection != null) {
            try {
                callableStatement = connection.prepareCall(GET_STUDENT_BY_ID);
                callableStatement.setInt(1, id);
                resultSet = callableStatement.executeQuery();
                if (resultSet.next()) {
                    student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAddress(resultSet.getString("address"));
                    student.setMoney(resultSet.getLong("money"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    callableStatement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return student;
    }

    @Override
    public int update(Student student) {
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        int count = 0;
        if (connection != null) {
            try {
                callableStatement = connection.prepareCall(UPDATE_STUDENT_BY_ID);
                callableStatement.setInt(1, student.getId());
                callableStatement.setString(2, student.getName());
                callableStatement.setString(3, student.getAddress());
                count = callableStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return count;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean transferMoney(int fromId, int toId, long money) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                connection.setAutoCommit(false);

                statement = connection.prepareStatement("update student set money = (money + ?) where id = ?");
                statement.setLong(1, -money);
                statement.setLong(2, fromId);
                statement.executeUpdate();

                statement = connection.prepareStatement("update student set money = (money + ?) where id = ?");
                statement.setLong(1, +money);
                statement.setLong(2, toId);
                statement.executeUpdate();

                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    connection.rollback();

                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    DBConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
