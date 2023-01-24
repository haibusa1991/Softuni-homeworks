package com.lab.models.entities;

import com.lab.models.enumeration.Role;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userRoleId;

    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private Role userRole;
}
