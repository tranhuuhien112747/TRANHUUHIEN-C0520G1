package dao;

import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement implements UsersDAO {
    private static final String SELECT_All_USER = "call showlist_user()";
    private static final String INSERT_USERS_SQL = "call addnewuser(?,?,?,?)";
    private static final String SELECT_USER_BY_ID = "call findby_id(?)";
    private static final String UPDATE_USERS_SQL = "call update_user(?,?,?,?)";
    private static final String DELETE_USERS_SQL = "call delete_user(?)";


    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
       CallableStatement statement=null;
        ResultSet resultSet = null;
        List<User> userArrayList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareCall(SELECT_All_USER);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("fullname");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userArrayList.add(user);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return userArrayList;
    }

    @Override
    public void create(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement=null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(INSERT_USERS_SQL);
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getCountry());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement=null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(UPDATE_USERS_SQL);
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getCountry());
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement=null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(DELETE_USERS_SQL);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public User findById(int id) {
        Connection connection = DBConnection.getConnection();
        User user = null;
       CallableStatement statement= null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(SELECT_USER_BY_ID);
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("fullname");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    user = new User(id, name, email, country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return user;
    }

}
