package com.lab.repositories;

import com.lab.models.entities.UserRole;
import com.lab.models.enumeration.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    UserRole getUserRoleByRole(Roles role);

//    List<UserRole> findAll();
}
