package com.examprep1.battleships.repositories;

import com.examprep1.battleships.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User getUserByUsernameAndPassword(String username, String password);

    User getUserByUsername(String username);
}
