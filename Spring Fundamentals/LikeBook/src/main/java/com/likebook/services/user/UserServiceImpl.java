package com.likebook.services.user;

import com.likebook.binding.LoginForm;
import com.likebook.binding.RegistrationForm;
import com.likebook.entities.User;
import com.likebook.repositories.UserRepository;
import com.likebook.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public void logoutUser() {
        this.userSession.setUsername(null);
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
    public User getCurrentUser() {
        String username = this.userSession.getUsername();
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public String getCurrentUsername() {
        return this.userSession.getUsername();
    }
}
