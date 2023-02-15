package com.examprep1.battleships.services.user;

import com.examprep1.battleships.entities.User;
import com.examprep1.battleships.binding.LoginForm;
import com.examprep1.battleships.binding.RegisterForm;
import com.examprep1.battleships.repositories.UserRepository;
import com.examprep1.battleships.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserSession userSession;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper,
                           UserSession userSession,
                           UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(RegisterForm registerForm) {
        User user = this.modelMapper.map(registerForm, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void loginUser(LoginForm loginForm) {
        User user = this.userRepository.getUserByUsernameAndPassword(loginForm.username, loginForm.password);
        if (user != null) {
            this.userSession.setUsername(user.getUsername());
        }
    }

    @Override
    public boolean hasLoggedUsed() {
        return this.userSession.getUsername() != null;
    }

    @Override
    public void logout() {
        this.userSession.setUsername(null);
    }

    @Override
    public User getCurrentUser() {
       return this.userRepository.getUserByUsername(this.userSession.getUsername());
    }
}
