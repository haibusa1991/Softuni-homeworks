package cardealer.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String make;

    private String model;

    @Column(name = "traveled_distance")
    private String traveledDistance;

    @ManyToMany
    private Set<Part> parts;

    public Car() {
        this.parts = new HashSet<>();
    }


    public Car(String make, String model, String traveledDistance, Set<Part> parts) {
        this();
        this.make = make;
        this.model = model;
        this.traveledDistance = traveledDistance;
        this.parts = parts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(String traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
