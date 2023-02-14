package com.lab.services.interfaces;

import com.lab.models.RegistrationForm;
import com.lab.models.entities.User;
import com.lab.models.entities.UserRole;
import com.lab.models.entities.dto.UserDto;

import java.util.List;

public interface UserRegistrationService {
    User registerUser(RegistrationForm registrationForm);

    String[] getUserRoles();
}
