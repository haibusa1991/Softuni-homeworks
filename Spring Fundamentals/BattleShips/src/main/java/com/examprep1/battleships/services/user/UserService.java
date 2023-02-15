package com.examprep1.battleships.services.user;

import com.examprep1.battleships.entities.User;
import com.examprep1.battleships.binding.LoginForm;
import com.examprep1.battleships.binding.RegisterForm;

public interface UserService {
    void registerUser(RegisterForm registerForm);

    void loginUser(LoginForm loginForm);

    boolean hasLoggedUsed();

    void logout();

    User getCurrentUser();
}
