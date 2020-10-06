package com.codegym.controllers;

import com.codegym.models.Student;
import com.codegym.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getListStudent")
    public ResponseEntity<List<Student>> getListOfStudents() {
        List<Student> studentList = studentService.findAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Void> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
