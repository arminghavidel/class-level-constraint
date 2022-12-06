package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NonEmptyListValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonEmptyList {

    String message() default "List should be non-empty!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
