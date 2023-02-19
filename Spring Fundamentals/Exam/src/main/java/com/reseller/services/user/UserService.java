package com.reseller.services.user;

import com.reseller.binding.LoginForm;
import com.reseller.binding.RegistrationForm;
import com.reseller.entities.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    boolean hasUser();

    void registerUser(RegistrationForm registrationForm);

    void loginUser(LoginForm loginForm);

    void logoutUser();

    User getCurrentUser();

    void saveUser(User user);

    List<User> getAllUsers();

    List<User> getAllOtherUsers();
}
