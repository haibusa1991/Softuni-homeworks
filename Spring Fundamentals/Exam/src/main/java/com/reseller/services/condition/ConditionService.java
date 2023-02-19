package com.reseller.services.condition;

import com.reseller.entities.Condition;

public interface ConditionService {
    String[] getAllConditions();

    Condition getConditionByName(String condition);
}
