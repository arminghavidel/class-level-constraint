package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.NonBlankString;
import com.example.classlevelconstraint.infrastructure.validation.NonEmptyList;
import jakarta.validation.Valid;
import lombok.Getter;

import java.util.List;

@Getter
public class BudgetStructureRequestModel {

    private Integer id;

    @NonBlankString
    private String name;
    private boolean disable;
    private String description;

    @Valid
    @NonEmptyList
    private List<SigningNodesRequestModel> signingNodes;
}
