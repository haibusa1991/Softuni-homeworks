package com.likebook.repositories;

import com.likebook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserByUsernameAndPassword(String username, String password);

    User getUserByUsername(String username);
}
