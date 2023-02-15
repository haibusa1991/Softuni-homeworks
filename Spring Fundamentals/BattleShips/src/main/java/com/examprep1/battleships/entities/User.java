package com.examprep1.battleships.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//import org.springframework.data.relational.core.mapping.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(min = 3, max = 10)
    @Column(unique = true)
    @NotNull
    private String username;


    @Column(name = "full_name")
    @Size(min = 5, max = 20)
    @NotNull
    private String fullName;

    @Size(min = 3)
    @NotNull
    private String password;


    @Email
    @Column(unique = true)
    @NotNull
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
