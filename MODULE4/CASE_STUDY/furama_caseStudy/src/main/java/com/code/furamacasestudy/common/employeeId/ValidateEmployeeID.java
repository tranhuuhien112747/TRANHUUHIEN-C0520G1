package com.code.furamacasestudy.common.employeeId;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmployeeIDConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateEmployeeID {
    String message() default "Id is invalid !!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
