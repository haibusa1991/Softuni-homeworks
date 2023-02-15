package com.examprep1.battleships.binding;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AddShipForm {

    @NotBlank
    @Size(min = 2, max = 10)
    public String name;

    @Positive
    public long power;

    @Positive
    public long health;

    @NotNull
    @PastOrPresent
    public LocalDate created;

    @NotBlank
    public String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
