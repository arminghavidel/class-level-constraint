package com.example.classlevelconstraint.infrastructure.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    /**
     * This regular expression is provided by the <a href=https://www.rfc-editor.org/info/rfc5322>RFC 5322 <a/>to check the email validation.
     * */
    private static final String VALID_EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty() && !value.isBlank() &&
                Pattern.compile(VALID_EMAIL_PATTERN).matcher(value).matches();
    }
}
