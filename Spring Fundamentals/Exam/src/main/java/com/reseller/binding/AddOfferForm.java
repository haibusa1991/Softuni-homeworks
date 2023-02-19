package com.reseller.binding;

import jakarta.validation.constraints.*;

public class AddOfferForm {

    @NotBlank
    @Size(min = 2, max = 50)
    private String description;

    @NotNull
    @Positive
    private double price;

    @NotBlank
    private String condition;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
