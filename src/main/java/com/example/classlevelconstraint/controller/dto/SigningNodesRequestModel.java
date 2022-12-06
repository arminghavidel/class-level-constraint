package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.PositiveInteger;
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

    @PositiveInteger
    private Integer requiredSignatureNumber;

    @PositiveInteger
    private Integer totalSignatureNumber;

    @ValidList
    private List<UserRequestModel> users;
}
