package com.code.furamacasestudy.common.employeeId;

import com.code.furamacasestudy.model.Employee;
import com.code.furamacasestudy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeIDConstraintValidator implements ConstraintValidator<ValidateEmployeeID,String> {
    @Autowired
    private EmployeeService employeeService;

    public final String VALIDATE_EMPLOYEE_ID = "^(NV)-[0-9]{4}$";

    private boolean checkValidateEmployeeId(String input) {
        Pattern pattern = Pattern.compile(VALIDATE_EMPLOYEE_ID);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public void initialize(ValidateEmployeeID constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!checkValidateEmployeeId(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("ID format NV-XXXX").addConstraintViolation();
            return false;
        }
        Employee employee = employeeService.finById(value);
        if (employee != null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Id had been already exists!!!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
