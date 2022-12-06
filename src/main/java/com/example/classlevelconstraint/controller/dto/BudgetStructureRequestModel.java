package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.ValidList;
import lombok.Getter;

import java.util.List;

@Getter
public class BudgetStructureRequestModel {

    private Integer id;
    private String name;
    private boolean disable;
    private String description;

    @ValidList
    private List<SigningNodesRequestModel> signingNodes;
}
