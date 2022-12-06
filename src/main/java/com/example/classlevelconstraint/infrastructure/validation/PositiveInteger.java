package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositiveIntegerValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveInteger {

    String message() default "Integer should be positive and non-zero!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
