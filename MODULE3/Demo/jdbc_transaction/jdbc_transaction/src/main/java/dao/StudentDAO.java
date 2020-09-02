package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    int update(Student student);

    void remove(int id);

    boolean transferMoney(int fromId, int toId, long money);
}
