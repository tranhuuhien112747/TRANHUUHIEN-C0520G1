package com.code.furamacasestudy.model;

import com.code.furamacasestudy.common.customerId.ValidateCustomerID;
import com.code.furamacasestudy.common.day.ValidateBirthdayGreater18;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class Customer {
    public interface CheckId { };

    public interface CheckEdit { };

    @Id
    @ValidateCustomerID(groups = CheckId.class)
    private String customerId;

    @NotEmpty(message = "Must be not empty", groups = CheckEdit.class)
    private String customerName;

    @ValidateBirthdayGreater18(groups = CheckEdit.class)
    private String customerBirthday;
    private int customerGender;

    @Pattern(regexp = "^\\d{9}$", message = "The card must have 9 numbers", groups = CheckEdit.class)
    private String customerIdCard;

    @Pattern(regexp = "^(090|091|(84)+90|(84)+91)\\d{7}$", message = "Please enter correct format", groups = CheckEdit.class)
    private String customerPhone;

    @Pattern(regexp = "^\\w+@\\w+[.]\\w+$", message = "Please enter the correct format abc@gmail.com", groups = CheckEdit.class)
    private String customerEmail;

    @NotEmpty(message = "Must be not empty", groups = CheckEdit.class)
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    private boolean status;

    public Customer() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

}
