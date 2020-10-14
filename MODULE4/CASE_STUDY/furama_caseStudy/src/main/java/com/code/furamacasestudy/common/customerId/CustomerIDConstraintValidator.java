package com.code.furamacasestudy.common.customerId;

import com.code.furamacasestudy.model.Customer;
import com.code.furamacasestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerIDConstraintValidator implements ConstraintValidator<ValidateCustomerID,String> {
   private final String VALIDATE_CUSTOMER_ID="^(KH)-[0-9]{4}$";
    @Autowired
    private CustomerService customerService;

    private boolean checkValidateCustomerId(String input) {
        Pattern pattern = Pattern.compile(VALIDATE_CUSTOMER_ID);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public void initialize(ValidateCustomerID constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!checkValidateCustomerId(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("ID format KH-XXXX").addConstraintViolation();
            return false;
        }
        Customer customer = customerService.finById(value);
        if (customer != null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Id had been already exists!!!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
