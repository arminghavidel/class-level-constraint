package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NonBlankStringValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonBlankString {

    String message() default "String should not be null or blank!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
