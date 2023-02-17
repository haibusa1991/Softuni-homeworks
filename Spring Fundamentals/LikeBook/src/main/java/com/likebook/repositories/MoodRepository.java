package com.likebook.repositories;

import com.likebook.entities.Mood;
import com.likebook.enumeration.MoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoodRepository extends JpaRepository<Mood, UUID> {

    Mood getMoodByMoodName(MoodType moodType);
}
