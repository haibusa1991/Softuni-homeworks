package com.reseller.services.condition;

import com.reseller.entities.Condition;
import com.reseller.enumeration.ConditionType;
import com.reseller.repositories.ConditionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @PostConstruct
    public void initConditions() {
        if (conditionRepository.count() > 0) {
            return;
        }

        List<Condition> conditions = Arrays.stream(ConditionType.values())
                .map(e -> new Condition(e, e.description))
                .toList();

        this.conditionRepository.saveAll(conditions);
    }

    @Override
    public String[] getAllConditions() {
        return this.conditionRepository
                .findAll()
                .stream()
                .map(e -> e.getName().name())
                .toArray(String[]::new);
    }

    @Override
    public Condition getConditionByName(String condition){
        return this.conditionRepository.getConditionByName(ConditionType.valueOf(condition));
    }
}
