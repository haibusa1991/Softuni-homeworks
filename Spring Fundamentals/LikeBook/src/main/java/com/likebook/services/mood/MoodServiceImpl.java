package com.likebook.services.mood;

import com.likebook.entities.Mood;
import com.likebook.enumeration.MoodType;
import com.likebook.repositories.MoodRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    @Autowired
    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @PostConstruct
    public void initMoodRepo() {
        if (this.moodRepository.count() > 0) {
            return;
        }

        List<Mood> strings = Arrays.stream(MoodType.values()).map(Mood::new).toList();
        this.moodRepository.saveAll(strings);
    }

    @Override
    public java.lang.String[] getAllMoods() {
        return this.moodRepository.findAll()
                .stream()
                .map(e -> e.moodName.name())
                .toArray(java.lang.String[]::new);
    }

    @Override
    public Mood getMoodByName(String moodName){
        return this.moodRepository.getMoodByMoodName(MoodType.valueOf(moodName));
    }
}
