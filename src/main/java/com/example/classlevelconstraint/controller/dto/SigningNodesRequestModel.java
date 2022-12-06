package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.*;
import jakarta.validation.Valid;
import lombok.Getter;

import java.util.List;

@Getter
@ValidDecisionWight
@ValidSignatureNumbers
public class SigningNodesRequestModel {

    private Integer id;

    @NonBlankString
    private String name;
    private String description;

    @PositiveInteger
    private Integer requiredSignatureNumber;

    @PositiveInteger
    private Integer totalSignatureNumber;

    @Valid
    @NonEmptyList
    private List<UserRequestModel> users;
}
