package com.lab.models.entities.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class BrandDto {
    private String name;

    private String created;

    private String modified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

}
