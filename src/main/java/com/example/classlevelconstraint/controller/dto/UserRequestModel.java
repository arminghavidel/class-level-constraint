package com.example.classlevelconstraint.controller.dto;

import lombok.Getter;

@Getter
public class UserRequestModel {

    private String email;
    private int decisionWeight;
    private boolean disable;
}
