package com.lab.services.implementation;

import com.lab.models.RegistrationForm;
import com.lab.models.entities.User;
import com.lab.models.entities.UserRole;
import com.lab.models.entities.dto.UserDto;
import com.lab.repositories.UserRoleRepository;
import com.lab.services.interfaces.UserRegistrationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRoleRepository userRoleRepository;

    public UserRegistrationServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public User registerUser(RegistrationForm registrationForm) {
        return null;
    }

    @Override
    public String[] getUserRoles() {
        List<UserRole> allRoles = this.userRoleRepository.findAll();
        return allRoles.stream().map(e -> e.getRole().toString()).toArray(String[]::new);
    }
}
