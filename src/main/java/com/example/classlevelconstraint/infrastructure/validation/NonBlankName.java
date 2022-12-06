package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NonBlankNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonBlankName {

    String message() default "Name should not be null or blank!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
