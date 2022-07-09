package automapper.annotations;

import automapper.validators.CapitalizedConstraintValidator;
import automapper.validators.HttpValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {HttpValidator.class})
public @interface Http {
    String message() default "Value must be a http:// or https:// protocol link";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
