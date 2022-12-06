package com.example.classlevelconstraint.infrastructure.validation;

import com.example.classlevelconstraint.controller.dto.SigningNodesRequestModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SignatureNumbersValidator implements
        ConstraintValidator<ValidSignatureNumbers, SigningNodesRequestModel> {

    @Override
    public boolean isValid(SigningNodesRequestModel value, ConstraintValidatorContext context) {
        return value.getRequiredSignatureNumber() <= value.getTotalSignatureNumber();
    }
}
