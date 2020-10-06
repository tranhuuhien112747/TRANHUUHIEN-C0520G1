package com.codegym.services.impl;

import com.codegym.models.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findByNameContaining(String keyword, Pageable pageable) {
        return studentRepository.findByNameContaining(keyword, pageable);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
