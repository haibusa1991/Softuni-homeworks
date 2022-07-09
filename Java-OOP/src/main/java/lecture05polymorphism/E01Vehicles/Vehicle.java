package lecture05polymorphism.E01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    private final double fuelConsumption;


    public Vehicle(double fuel, double fuelConsumption) {
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
    }

    public void refuel(double amount) {
        this.fuel += amount;
    }

    public String drive(double distance) {
        double fuelNeeded = fuelConsumption * distance;
        if (fuelNeeded > fuel) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        this.fuel -= fuelNeeded;
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
