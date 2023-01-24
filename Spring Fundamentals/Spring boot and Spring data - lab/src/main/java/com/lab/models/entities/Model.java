package com.lab.models.entities;


import com.lab.models.enumeration.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID modelId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "imageUrl", length = 512)
    @Size(min=8,max=512)
    private String imageUlr;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "end_year")
    private int endYear;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
