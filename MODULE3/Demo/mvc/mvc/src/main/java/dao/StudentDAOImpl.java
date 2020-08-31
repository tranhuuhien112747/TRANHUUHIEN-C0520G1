package dao;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements  StudentDAO{
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Le Nhat","Da Nang"));
        studentList.add(new Student(2,"Le Toan","Da Nang"));
        studentList.add(new Student(3,"Nguyen Tien Hai","Da Nang"));
        studentList.add(new Student(4,"Nguyen Huu Quang","Da Nang"));
        studentList.add(new Student(5,"Phan Quoc Khanh","Da Nang"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean save(Student student) {
        studentList.add(student);
        return true;
    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
