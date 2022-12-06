package com.example.classlevelconstraint.controller.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BudgetStructureRequestModel {

    private Integer id;
    private String name;
    private boolean disable;
    private String description;
    private List<SigningNodesRequestModel> signingNodes;
}
