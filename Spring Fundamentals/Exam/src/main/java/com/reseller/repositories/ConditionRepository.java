package com.reseller.repositories;

import com.reseller.entities.Condition;
import com.reseller.enumeration.ConditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, UUID> {

    Condition getConditionByName(ConditionType conditionType);
}
