package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.NonEmptyList;
import com.example.classlevelconstraint.infrastructure.validation.NonBlankName;
import jakarta.validation.Valid;

import java.util.List;

public record CreateVaultRequest(
        Integer id,
        @NonBlankName String name,
        String description,
        boolean disable,
        @Valid @NonEmptyList List<BudgetStructureRequestModel> budgetStructures
) {
}

