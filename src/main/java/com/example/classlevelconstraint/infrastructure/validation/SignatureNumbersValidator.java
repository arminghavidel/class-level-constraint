package com.example.classlevelconstraint.infrastructure.validation;


import com.example.classlevelconstraint.controller.dto.SigningNodesRequestModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Check the requiredSignatureNumber property to be less than or equal to totalSignatureNumber property.
 */
public class SignatureNumbersValidator implements
        ConstraintValidator<ValidSignatureNumbers, SigningNodesRequestModel> {

    @Override
    public boolean isValid(SigningNodesRequestModel value, ConstraintValidatorContext context) {
        return value.requiredSignatureNumber() <= value.totalSignatureNumber();
    }
}
