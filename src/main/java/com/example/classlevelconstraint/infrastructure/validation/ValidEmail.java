package com.example.classlevelconstraint.infrastructure.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

    String message() default "Email format should be valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
