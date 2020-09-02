package bo;

import dao.UserDaoImplement;
import dao.UsersDAO;
import model.User;

import java.util.List;

public class UserBoImplement implements UserBo {
    private UsersDAO usersDAO = new UserDaoImplement();

    @Override
    public List<User> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public void create(User user) {
        usersDAO.create(user);
    }

    @Override
    public void update(User user) {
        usersDAO.update(user);
    }

    @Override
    public void delete(int id) {
        usersDAO.delete(id);
    }

    @Override
    public User findById(int id) {
        return usersDAO.findById(id);
    }

    @Override
    public List<User> searchName(String byname) {
        return usersDAO.SearchName(byname);
    }

    @Override
    public List<User> sortByName() {
        return usersDAO.sortByName();
    }
}
