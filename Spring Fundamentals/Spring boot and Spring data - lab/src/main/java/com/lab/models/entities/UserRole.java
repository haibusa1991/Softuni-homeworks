package com.lab.models.entities;

import com.lab.models.enumeration.Roles;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userRoleId;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Roles role;

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles userRole) {
        this.role = userRole;
    }
}
