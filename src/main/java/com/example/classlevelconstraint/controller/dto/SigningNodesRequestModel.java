package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.ValidList;
import com.example.classlevelconstraint.infrastructure.validation.ValidString;
import lombok.Getter;

import java.util.List;

@Getter
public class SigningNodesRequestModel {

    private Integer id;

    @ValidString
    private String name;
    private String description;
    private int requiredSignatureNumber;
    private int totalSignatureNumber;

    @ValidList
    private List<UserRequestModel> users;
}
