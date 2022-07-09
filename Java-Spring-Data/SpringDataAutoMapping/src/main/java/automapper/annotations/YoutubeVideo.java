package automapper.annotations;

import automapper.validators.PasswordConstraintValidator;
import automapper.validators.YoutubeVideoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {YoutubeVideoValidator.class})
public @interface YoutubeVideo {
    String message() default "Value must be video id or youtube link";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
