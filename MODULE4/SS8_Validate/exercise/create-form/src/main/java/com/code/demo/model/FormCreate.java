package com.code.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class FormCreate implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fistName;
    private String lastName;
    @NotEmpty(message = "k dc de trong")
    private String phoneNumber;
    private int age;
    @NotEmpty(message = "k dc de trong")
    @Email(message = "email k hop le")
    private String email;

    public FormCreate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FormCreate.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormCreate formCreate = (FormCreate) target;
        String fistName = formCreate.getFistName();
        String lastName = formCreate.getLastName();
        String phone = formCreate.getPhoneNumber();
//        String email = formCreate.getEmail();
        int age = formCreate.getAge();

//        if (fistName.isEmpty() || lastName.isEmpty()) {
//            errors.rejectValue("mess", "name.isEmpty");
//        }
        if (fistName.length() < 5 || fistName.length() > 45){
            errors.rejectValue("fistName", "fistName.length");
        }
        if (lastName.length() < 5 || lastName.length() > 45){
            errors.rejectValue("lastName", "lastName.length");
        }
        if (age < 18) {
            errors.rejectValue("age", "age.18");
        }
        if (!phone.matches("^(0)[1-9]{9}$")) {
            errors.rejectValue("phoneNumber", "phone.matches");
        }

    }
}
