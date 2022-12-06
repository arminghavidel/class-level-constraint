package com.example.classlevelconstraint.infrastructure.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidString {

    String message() default "String should not be null or blank!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
