package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.*;
import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;

import java.util.List;

@ValidDecisionWight(groups = ClassLevelConstraint.class)
@ValidSignatureNumbers(groups = ClassLevelConstraint.class)
@GroupSequence(value = {SigningNodesRequestModel.class, FieldLevelConstraint.class, ClassLevelConstraint.class})
public record SigningNodesRequestModel(
        Integer id,
        @NonBlankName String name,
        String description,
        @PositiveInteger(groups = FieldLevelConstraint.class, message = "required signature number should be positive and non-zero!")
        Integer requiredSignatureNumber,
        @PositiveInteger(groups = FieldLevelConstraint.class, message = "total signature number should be positive and non-zero!")
        Integer totalSignatureNumber,
        @Valid @NonEmptyList List<UserRequestModel> users
) {
}
