package com.likebook.entities;

import com.likebook.enumeration.MoodType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @NotNull
    @Size(min = 2, max = 150)
    public String content;

    @NotNull
    @ManyToOne
    public User user;

    @ManyToMany(fetch = FetchType.EAGER)
    public List<User> userLikes;

    @NotNull
    @ManyToOne
    public Mood mood;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public UUID getId() {
        return id;
    }
}
