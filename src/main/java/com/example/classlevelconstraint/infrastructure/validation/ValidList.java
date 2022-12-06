package com.example.classlevelconstraint.infrastructure.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ListValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidList {

    String message() default "List should be non-empty!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
