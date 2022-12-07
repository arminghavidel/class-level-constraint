package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.PositiveInteger;
import com.example.classlevelconstraint.infrastructure.validation.ValidEmail;

public record UserRequestModel(
        @ValidEmail String email,
        @PositiveInteger(message = "Decision weight should be positive and non-zero!")
        Integer decisionWeight,
        boolean disable
) {
}
