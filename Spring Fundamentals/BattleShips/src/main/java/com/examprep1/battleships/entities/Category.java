package com.examprep1.battleships.entities;

import com.examprep1.battleships.enumeration.ShipCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ShipCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category(ShipCategory name) {
        this.name = name;
    }

    public Category() {

    }

    public ShipCategory getName() {
        return name;
    }

    public void setName(ShipCategory name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
