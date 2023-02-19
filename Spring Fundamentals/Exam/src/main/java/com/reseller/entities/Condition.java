package com.reseller.entities;

import com.reseller.enumeration.ConditionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "conditions")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(value = EnumType.STRING)
    @Column(unique = true)
    @NotNull
    private ConditionType name;

    @NotNull
    private String description;

    public Condition() {
    }

    public Condition(ConditionType name, String description) {
        this.name = name;
        this.description = description;
    }

    public ConditionType getName() {
        return name;
    }

    public void setName(ConditionType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
