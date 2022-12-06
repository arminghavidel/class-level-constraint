package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.NonEmptyList;
import com.example.classlevelconstraint.infrastructure.validation.NonBlankName;
import jakarta.validation.Valid;

import java.util.List;

public record BudgetStructureRequestModel(
        Integer id,
        @NonBlankName String name,
        boolean disable,
        String description,
        @Valid @NonEmptyList List<SigningNodesRequestModel> signingNodes
) {
}
