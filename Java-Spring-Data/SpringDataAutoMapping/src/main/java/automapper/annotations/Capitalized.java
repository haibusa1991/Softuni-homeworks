package automapper.annotations;

import automapper.validators.CapitalizedConstraintValidator;
import automapper.validators.PasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {CapitalizedConstraintValidator.class})
public @interface Capitalized {
    String message() default "Field must start with a capital letter!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
