package bo;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO{
    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public Student findById(int id) {
        return  studentDAO.findById(id);
    }

    @Override
    public int update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean validateStudent() {
        return false;
    }

    @Override
    public boolean transferMoney(int fromId, int toId, long money) {
        return studentDAO.transferMoney(fromId, toId, money);
    }


}
