package com.lab.models.entities;

import com.lab.models.enumeration.Engine;
import com.lab.models.enumeration.Transmision;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID offerId;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "engine")
    @Enumerated(value = EnumType.STRING)
    private Engine engine;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "mileage ")
    private int mileage;

    @Column(name = "price")
    private double price;

    @Column(name = "transmission ")
    @Enumerated(value = EnumType.STRING)
    private Transmision transmission;

    @Column(name = "year")
    private Year year;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @ManyToOne()
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User seller;







}