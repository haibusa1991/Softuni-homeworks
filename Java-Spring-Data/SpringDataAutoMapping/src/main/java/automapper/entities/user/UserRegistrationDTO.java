package automapper.entities.user;

import automapper.annotations.Password;

import javax.validation.constraints.Email;

public class UserRegistrationDTO {
    @Email
    private String email;

    @Password(minLength = 6,
            shouldContainUppercase = true,
            shouldContainLowercase = true,
            shouldContainDigit = true)
    private String password;

    private String fullName;

    private boolean matchingPasswords;

    public UserRegistrationDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserRegistrationDTO(String registrationInfo) {
        //tokens[0] is the register command name
        String[] tokens = registrationInfo.split("\\|");
        String email = tokens[1];
        String password = tokens[2];
        String passwordRepeated = tokens[3];
        String fullName = tokens[4];

        this.email = email;
        this.password = password;
        this.fullName = fullName;

        this.matchingPasswords = areMatchingPasswords(password, passwordRepeated);
    }

    private boolean areMatchingPasswords(String password, String passwordRepeated) {
        return password.equals(passwordRepeated);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean areMatchingPasswords() {
        return this.matchingPasswords;
    }
}
