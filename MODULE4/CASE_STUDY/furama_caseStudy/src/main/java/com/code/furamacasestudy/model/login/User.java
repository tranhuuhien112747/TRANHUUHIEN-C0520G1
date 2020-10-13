package com.code.furamacasestudy.model.login;

import com.code.furamacasestudy.model.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;
    private String userPassword;

    @OneToMany(mappedBy = "user")
    private Set<Employee> employeeSet;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "userRole",joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "userName"))
    private Set<Role> roles;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
