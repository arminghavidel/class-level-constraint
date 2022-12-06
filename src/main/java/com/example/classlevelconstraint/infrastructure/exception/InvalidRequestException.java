package com.example.classlevelconstraint.infrastructure.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(BindingResult result) {
        super(result.getFieldErrors().stream()
                .filter(fe -> fe.getDefaultMessage() != null)
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Invalid request!"));
    }
}
