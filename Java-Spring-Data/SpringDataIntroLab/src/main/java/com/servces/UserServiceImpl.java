package com.servces;

import com.models.User;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User foundUser = userRepository.findUserByUsername(user.getUsername());
        if (foundUser == null) {
            userRepository.save(user);
        }

    }
}
