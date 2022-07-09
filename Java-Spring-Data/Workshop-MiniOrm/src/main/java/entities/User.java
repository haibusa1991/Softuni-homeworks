package entities;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.time.LocalDate;

@Entity(name = "users")
public class User {
    @Id
    private long id = -1;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "age")
    private int age;

    @Column(name = "registration")
    private LocalDate registration;

    public User(String username, String password, int age, LocalDate registration) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.registration = registration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }
}
