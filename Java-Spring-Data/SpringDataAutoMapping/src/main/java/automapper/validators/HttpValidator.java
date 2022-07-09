package automapper.validators;

import automapper.annotations.Http;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HttpValidator implements ConstraintValidator<Http, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String protocol = value.toLowerCase().split("://")[0];
        return protocol.equals("http") || protocol.equals("https");
    }
}
