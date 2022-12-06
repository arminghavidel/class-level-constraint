package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SignatureNumbersValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSignatureNumbers {

    String message() default "The requiredSignatureNumber property should be less than or equal to totalSignatureNumber property!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
