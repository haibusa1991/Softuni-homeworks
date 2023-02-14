package com.examprep1.battleships.services;

import com.examprep1.battleships.entities.User;
import com.examprep1.battleships.entities.dto.RegisterFormDto;
import com.examprep1.battleships.repositories.UserRepository;
import com.examprep1.battleships.session.UserSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ModelMapper modelMapper;
    private final UserSession userSession;
    private final UserRepository userRepository;

    @Autowired
    public UserService(ModelMapper modelMapper,
                       UserSession userSession,
                       UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userSession = userSession;
        this.userRepository = userRepository;
    }

    public void registerUser(RegisterFormDto registerFormDto) {
        User user = this.modelMapper.map(registerFormDto, User.class);
        this.userRepository.save(user);
    }
}
