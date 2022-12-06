package com.example.classlevelconstraint.controller.dto;

import com.example.classlevelconstraint.infrastructure.validation.PositiveInteger;
import com.example.classlevelconstraint.infrastructure.validation.ValidEmail;
import lombok.Getter;

@Getter
public class UserRequestModel {

    @ValidEmail
    private String email;

    @PositiveInteger
    private Integer decisionWeight;
    private boolean disable;
}
