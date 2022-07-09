package lecture05polymorphism.E02VehiclesExtended;

public abstract class Vehicle {
    private double fuel;
    private double fuelConsumption;
    private final double tankCapacity;


    public Vehicle(double fuel, double fuelConsumption, double tankCapacity) {
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public void refuel(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double maxRefuelAmount = tankCapacity - fuel;
        if (amount > maxRefuelAmount) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuel += amount;
    }

    public void drive(double distance) {
        double fuelNeeded = fuelConsumption * distance;
        if (fuelNeeded > fuel) {
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuel -= fuelNeeded;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
