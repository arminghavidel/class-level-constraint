package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class NonEmptyListValidator implements ConstraintValidator<NonEmptyList, List<?>> {

    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}
