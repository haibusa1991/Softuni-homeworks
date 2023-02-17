package com.likebook.services.mood;

import com.likebook.entities.Mood;

public interface MoodService {
    String[] getAllMoods();

    Mood getMoodByName(String moodName);
}
