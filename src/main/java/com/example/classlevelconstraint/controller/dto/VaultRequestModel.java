package com.example.classlevelconstraint.controller.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class VaultRequestModel {

    private Integer id;
    private String name;
    private String description;
    private boolean disable;
    private List<BudgetStructureRequestModel> budgetStructures;
}
