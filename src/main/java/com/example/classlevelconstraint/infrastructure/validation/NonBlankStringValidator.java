package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonBlankStringValidator implements ConstraintValidator<NonBlankString, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty() && !value.isBlank();
    }
}