package automapper.entities.exceptions;

public class PasswordsNotMatchingException extends Exception {

    public PasswordsNotMatchingException(String message) {
        super(message);
    }
}
