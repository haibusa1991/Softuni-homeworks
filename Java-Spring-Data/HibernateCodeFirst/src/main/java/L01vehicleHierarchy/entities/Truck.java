package L01vehicleHierarchy.entities;

import L02Relations.entities.Driver;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Truck extends Vehicle {

    @Column(name = "load_capacity")
    private double loadCapacity;

    @ManyToMany
    @JoinTable(
            name = "l01_drivers_trucks",
            joinColumns = @JoinColumn(name = "truck_id",referencedColumnName = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "driver_id"))
    Set<Driver> drivers = new HashSet<>();

    public Truck() {
    }

    public Truck(VehicleType vehicleType, String model, BigDecimal price, FuelType fuelType, double loadCapacity) {
        super(vehicleType, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }
}
