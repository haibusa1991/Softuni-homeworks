package L01vehicleHierarchy.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "l01_vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;

    @Column(name = "vehicle_model")
    private String model;

    @Column(name = "vehicle_price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, String model, BigDecimal price, FuelType fuelType) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}
