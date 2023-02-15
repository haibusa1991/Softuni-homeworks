package com.examprep1.battleships.binding;

import jakarta.validation.constraints.*;

public class RegisterForm {

    @Size(min = 3, max = 10)
    @NotBlank
    public String username;

    @Size(min = 5, max = 20)
    @NotBlank
    public String fullName;

    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Size(min = 3)
    public String password;

    @NotBlank
    @Size(min = 3)
    public String rePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
