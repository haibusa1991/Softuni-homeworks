package com.likebook.services.user;

import com.likebook.binding.LoginForm;
import com.likebook.binding.RegistrationForm;
import com.likebook.entities.User;

public interface UserService {
    boolean hasUser();

    void logoutUser();

    void registerUser(RegistrationForm registrationForm);

    void loginUser(LoginForm loginForm);

    User getCurrentUser();

    String getCurrentUsername();
}
