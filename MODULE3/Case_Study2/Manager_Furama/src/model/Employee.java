package model;

import java.sql.Date;

public class Employee {
    private int employeeId;
    private String employeeName;
    private Date employeeBirthday;
    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private int employeePosition;
    private int employeeDivision;
    private int employeeEducation;
    private String userName;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, Date employeeBirthday, String employeeIdCard,
                    double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress
            , int employeePosition, int employeeDivision, int employeeEducation, String userName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.employeePosition = employeePosition;
        this.employeeDivision = employeeDivision;
        this.employeeEducation = employeeEducation;
        this.userName = userName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
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

    public int getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(int employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getEmployeeDivision() {
        return employeeDivision;
    }

    public void setEmployeeDivision(int employeeDivision) {
        this.employeeDivision = employeeDivision;
    }

    public int getEmployeeEducation() {
        return employeeEducation;
    }

    public void setEmployeeEducation(int employeeEducation) {
        this.employeeEducation = employeeEducation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
