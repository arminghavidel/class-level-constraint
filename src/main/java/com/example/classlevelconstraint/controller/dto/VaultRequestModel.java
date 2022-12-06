package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.ValidList;
import lombok.Getter;

import java.util.List;

@Getter
public class VaultRequestModel {

    private Integer id;
    private String name;
    private String description;
    private boolean disable;

    @ValidList
    private List<BudgetStructureRequestModel> budgetStructures;
}
