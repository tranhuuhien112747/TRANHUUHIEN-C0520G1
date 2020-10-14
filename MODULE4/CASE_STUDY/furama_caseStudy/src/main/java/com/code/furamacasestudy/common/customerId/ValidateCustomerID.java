package com.code.furamacasestudy.common.customerId;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomerIDConstraintValidator.class )
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateCustomerID {
    String message() default "Id is invalid!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
