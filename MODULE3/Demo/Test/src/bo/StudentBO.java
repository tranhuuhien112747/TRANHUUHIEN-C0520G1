package bo;

import model.Student;

import java.util.List;

public interface StudentBO {
    List<Student> findAllStudent();

    void create(Student student);

    void update(Student student);

    void delete(String id);

    Student findById(String id);

    List<Student> searchName(String name);

    boolean checkStudentIdExists(String id);
}
