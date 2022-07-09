package com.validators;

import com.annotations.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private Password password;
    private ConstraintValidatorContext context;
    private String value;
    private int violationsCount = 0;

    private static final List<Character> specialSymbols = Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '<', '>', '?');

    private static final String PASSWORD_TOO_SHORT = "Password should be at least %d characters";
    private static final String PASSWORD_MIN_MAX_LENGTH_MISMATCH = "Password min length cannot be greater than max length";
    private static final String PASSWORD_TOO_LONG = "Password should be no longer than %d characters";
    private static final String PASSWORD_NO_DIGIT = "Password should contain at least 1 digit";
    private static final String PASSWORD_NO_LOWERCASE = "Password should contain at least 1 lowercase letter";
    private static final String PASSWORD_NO_UPPERCASE = "Password should contain at least 1 uppercase letter";
    private static final String PASSWORD_NO_SPECIAL_SYMBOL = "Password should contain at least 1 special symbol (" +
            specialSymbols.stream().map(e -> e + "").collect(Collectors.joining(", ")) + ")";


    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.password = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        this.value = value;
        this.context = context;
        context.disableDefaultConstraintViolation();

        if (this.password.minLength() > this.password.maxLength()) {
            setMessage(PASSWORD_MIN_MAX_LENGTH_MISMATCH);
            violationsCount++;
        }

        if (this.value.length() < this.password.minLength()) {
            setMessage(String.format(PASSWORD_TOO_SHORT, this.password.minLength()));
            violationsCount++;
        }

        if (this.value.length() > this.password.maxLength()) {
            setMessage(String.format(PASSWORD_TOO_LONG, this.password.maxLength()));
            violationsCount++;
        }

        if (!doesContainDigit()) {
            violationsCount++;
            setMessage(PASSWORD_NO_DIGIT);
        }

        if (!doesContainLowercase()) {
            violationsCount++;
            setMessage(PASSWORD_NO_LOWERCASE);
        }

        if (!doesContainUppercase()) {
            violationsCount++;
            setMessage(PASSWORD_NO_UPPERCASE);
        }

        if (!doesContainSpecialSymbol()) {
            violationsCount++;
            setMessage(PASSWORD_NO_SPECIAL_SYMBOL);
        }

        return violationsCount == 0;
    }

    private boolean doesContainDigit() {
        if (!this.password.shouldContainDigit()) {
            return true;
        }

        for (char c : this.value.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesContainLowercase() {
        if (!this.password.shouldContainLowercase()) {
            return true;
        }

        for (char c : this.value.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesContainUppercase() {
        if (!this.password.shouldContainUppercase()) {
            return true;
        }

        for (char c : this.value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean doesContainSpecialSymbol() {
        if (!this.password.shouldContainSpecialSymbol()) {
            return true;
        }

        for (char c : this.value.toCharArray()) {
            if (specialSymbols.contains(c)) {
                return true;
            }
        }
        return false;
    }

    private void setMessage(String message) {
        this.context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
