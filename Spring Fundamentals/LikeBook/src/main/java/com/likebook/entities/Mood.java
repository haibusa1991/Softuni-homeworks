package com.likebook.entities;

import com.likebook.enumeration.MoodType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Enumerated(value = EnumType.STRING)
    @Column(unique = true)
    @NotNull
    public MoodType moodName;

    public java.lang.String description;

    public MoodType getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodType moodName) {
        this.moodName = moodName;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public Mood() {
    }

    public Mood(MoodType moodName) {
        this.moodName = moodName;
    }
}
