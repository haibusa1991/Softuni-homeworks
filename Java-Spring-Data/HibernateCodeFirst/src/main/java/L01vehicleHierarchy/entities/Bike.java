package L01vehicleHierarchy.entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Bike extends Vehicle {
    public Bike(VehicleType vehicleType, String model, BigDecimal price, FuelType fuelType) {
        super(vehicleType, model, price, fuelType);
    }

    public Bike() {
    }
}
