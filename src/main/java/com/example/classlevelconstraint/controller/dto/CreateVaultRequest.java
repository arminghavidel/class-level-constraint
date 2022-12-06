package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.NonBlankString;
import com.example.classlevelconstraint.infrastructure.validation.NonEmptyList;
import jakarta.validation.Valid;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateVaultRequest {

    private Integer id;

    @NonBlankString
    private String name;
    private String description;
    private boolean disable;

    @Valid
    @NonEmptyList
    private List<BudgetStructureRequestModel> budgetStructures;
}
