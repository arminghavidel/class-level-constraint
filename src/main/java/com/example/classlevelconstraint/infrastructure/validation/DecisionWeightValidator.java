package com.example.classlevelconstraint.infrastructure.validation;


import com.example.classlevelconstraint.controller.dto.SigningNodesRequestModel;
import com.example.classlevelconstraint.controller.dto.UserRequestModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

/**
 * Check sum of all decisionWeight property of users be equal to totalSignatureNumber property.
 */
public class DecisionWeightValidator implements
        ConstraintValidator<ValidDecisionWight, SigningNodesRequestModel> {

    @Override
    public boolean isValid(SigningNodesRequestModel value, ConstraintValidatorContext context) {
        return value.users().stream()
                .map(UserRequestModel::decisionWeight)
                .filter(Objects::nonNull)
                .reduce(Integer::sum)
                .map(sum -> sum.equals(value.totalSignatureNumber()))
                .orElse(false);
    }
}
