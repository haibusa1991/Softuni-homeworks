package com.reseller.services.user;

import com.reseller.binding.LoginForm;
import com.reseller.binding.RegistrationForm;
import com.reseller.entities.User;
import com.reseller.repositories.UserRepository;
import com.reseller.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserSession userSession;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserSession userSession, UserRepository userRepository, ModelMapper modelMapper) {
        this.userSession = userSession;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean hasUser() {
        return this.userSession.getUsername() != null;
    }

    @Override
    public void registerUser(RegistrationForm registrationForm) {
        User user = this.modelMapper.map(registrationForm, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void loginUser(LoginForm loginForm) {
        User user = this.userRepository.getUserByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());

        if (user != null) {
            this.userSession.setUsername(user.getUsername());
        }
    }

    @Override
    public void logoutUser() {
        this.userSession.setUsername(null);
    }

    @Override
    public User getCurrentUser() {
        String username = this.userSession.getUsername();
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> getAllOtherUsers() {
        if (getCurrentUser() == null) {
            return new ArrayList<>();
        }

        return this.userRepository.findAll()
                .stream()
                .filter(e -> !e.getUsername().equals(getCurrentUser().getUsername()))
                .toList();
    }
}
