package com.codegym.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @NotEmpty(message = "Khong duoc de trong")
//    @Pattern(regexp="[A-Za-z]+")
    private String name;
    private String birthday;

    @ManyToOne
    @JoinColumn(name = "class_student_id")
//    @JsonManagedReference
    @JsonIdentityReference(alwaysAsId = true)
    private ClassStudent classStudent;

    public Student() {
    }

    public Student(Integer id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ClassStudent getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(ClassStudent classStudent) {
        this.classStudent = classStudent;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;

        if (!student.name.matches("[A-Za-z]+")) {
            errors.rejectValue("name", "student.name");
        }
    }
}
