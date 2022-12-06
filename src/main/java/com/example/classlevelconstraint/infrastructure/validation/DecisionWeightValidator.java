package com.example.classlevelconstraint.infrastructure.validation;


import com.example.classlevelconstraint.controller.dto.SigningNodesRequestModel;
import com.example.classlevelconstraint.controller.dto.UserRequestModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DecisionWeightValidator implements
        ConstraintValidator<ValidDecisionWight, SigningNodesRequestModel> {

    @Override
    public boolean isValid(SigningNodesRequestModel value, ConstraintValidatorContext context) {
        return value.users().stream()
                .map(UserRequestModel::decisionWeight)
                .reduce(Integer::sum)
                .map(sum -> sum.equals(value.totalSignatureNumber()))
                .orElse(false);
    }
}
