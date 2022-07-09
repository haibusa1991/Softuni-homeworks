package automapper.validators;

import automapper.annotations.Capitalized;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CapitalizedConstraintValidator implements ConstraintValidator<Capitalized, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Character.isUpperCase(value.charAt(0));
    }
}
