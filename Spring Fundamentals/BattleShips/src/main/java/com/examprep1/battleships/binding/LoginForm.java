package com.examprep1.battleships.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginForm {
    @Size(min = 3,max = 10)
    @NotBlank
    public String username;

    @Size(min = 3,max = 10)
    @NotBlank
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
