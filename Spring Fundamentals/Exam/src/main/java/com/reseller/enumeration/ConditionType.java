package com.reseller.enumeration;

public enum ConditionType {
    EXCELLENT("In perfect condition"),
    GOOD("Some signs of wear and tear or minor defects"),
    ACCEPTABLE("The item is fairly worn but continues to function properly");

    public final String description;

    ConditionType(String description) {
        this.description = description;
    }
}
