package L01vehicleHierarchy.entities;

import L02Relations.entities.PlateNumber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Car extends Vehicle {

    private int hasSeats;

    @OneToOne(targetEntity = PlateNumber.class)
    private PlateNumber plateNumber;

    public Car(VehicleType vehicleType, String model, BigDecimal price, FuelType fuelType, int hasSeats) {
        super(vehicleType, model, price, fuelType);
        this.hasSeats = hasSeats;
    }

    public Car() {
    }


    public int getHasSeats() {
        return hasSeats;
    }

    public void setHasSeats(int hasSeats) {
        this.hasSeats = hasSeats;
    }

    public void setPlateNumber(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }

    public PlateNumber getPlateNumber() {
        return plateNumber;
    }
}
