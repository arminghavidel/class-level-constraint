package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.*;
import lombok.Getter;

import java.util.List;

@Getter
@ValidDecisionWight
@ValidSignatureNumbers
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
