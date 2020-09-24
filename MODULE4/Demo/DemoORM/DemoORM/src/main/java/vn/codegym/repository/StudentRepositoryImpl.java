package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> findAll() {
        Session session = null;
        List<Student> studentList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            studentList = session.createQuery("FROM Student").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(student);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        Session session = null;
        Student student = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            student = session.get(Student.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public void update(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(student);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
//        studentList.remove(id);
    }
}
