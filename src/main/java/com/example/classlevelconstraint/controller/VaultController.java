package com.example.classlevelconstraint.controller;

import com.example.classlevelconstraint.controller.dto.CreateVaultRequest;
import com.example.classlevelconstraint.infrastructure.exception.InvalidRequestException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaults")
public class VaultController {

    @PostMapping
    public ResponseEntity<Integer> create(@Valid @RequestBody CreateVaultRequest request, BindingResult result){
        if(result.hasErrors()) {
            throw new InvalidRequestException(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(request.id());
    }
}
