package dao;

import model.User;

import java.util.List;

public interface UsersDAO {
    List<User> findAll();

    void create(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);

//    List<User> SearchName(String name);
}
