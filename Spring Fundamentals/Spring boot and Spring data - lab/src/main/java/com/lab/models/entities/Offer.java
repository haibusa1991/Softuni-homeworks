package com.lab.models.entities;

import com.lab.models.enumeration.Engines;
import com.lab.models.enumeration.Transmissions;
import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    private Engines engine;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "mileage ")
    private int mileage;

    @Column(name = "price")
    private double price;

    @Column(name = "transmission ")
    @Enumerated(value = EnumType.STRING)
    private Transmissions transmission;

    @Column(name = "year")
    private int year;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engines getEngine() {
        return engine;
    }

    public void setEngine(Engines engines) {
        this.engine = engines;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmissions transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
