package com.code.furamacasestudy.model;

import com.code.furamacasestudy.common.employeeId.ValidateEmployeeID;
import com.code.furamacasestudy.model.login.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class Employee{
    public interface CheckID{};
    public interface EditCheck{};
    @Id
    @ValidateEmployeeID(groups = CheckID.class)
    private String employeeId;

    @NotEmpty(message = "Must be not empty",groups = EditCheck.class)
    private String employeeName;

    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"
    ,message = "Please enter your date of birth correct format",groups = EditCheck.class)
    private String employeeBirthday;

    @Pattern(regexp = "^\\d{9}$", message = "The card must have 9 numbers",groups = EditCheck.class)
    private String employeeIdCard;

    @Pattern(regexp = "^[-]*\\d+([.]\\d+)?$",message = "Salary must be >0",groups = EditCheck.class)
    private String employeeSalary;

    @Pattern(regexp = "^(090|091|(84)+90|(84)+91)\\d{7}$",message = "Please enter correct format",groups = EditCheck.class)
    private String employeePhone;

    @Pattern(regexp = "^\\w+@\\w+[.]\\w+$",message = "Please enter the correct format abc@gmail.com",groups = EditCheck.class)
    private String employeeEmail;

    @NotEmpty(message = "Must be not empty",groups = EditCheck.class)
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "educationId")
    private Education education;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;

    @ManyToOne
    @JoinColumn(name = "userName")
    private User user;

//    private String userName;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }


    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
