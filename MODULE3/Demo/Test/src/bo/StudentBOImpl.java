package bo;

import dao.StudentDAO;
import dao.StudentDAOIMPL;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = new StudentDAOIMPL();

    @Override
    public List<Student> findAllStudent() {
        return studentDAO.findAllStudent();
    }

    @Override
    public void create(Student student) {
        studentDAO.create(student);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void delete(String id) {
        studentDAO.delete(id);
    }

    @Override
    public Student findById(String id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> searchName(String name) {
        return studentDAO.searchName(name);
    }

    @Override
    public boolean checkStudentIdExists(String id) {
        return false;
    }
}
