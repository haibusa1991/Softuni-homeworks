package L01vehicleHierarchy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Plane extends Vehicle {

    @Column(name = "passenger_capacity")
    private int passengerCapacity;


    public Plane(VehicleType vehicleType, String model, BigDecimal price, FuelType fuelType, int passengerCapacity) {
        super(vehicleType, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public Plane() {
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

}
