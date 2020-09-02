package bo;

import model.User;

import java.util.List;

public interface UserBo {
    List<User> findAll();

    void create(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);
}
