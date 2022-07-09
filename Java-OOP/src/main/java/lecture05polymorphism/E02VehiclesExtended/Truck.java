package lecture05polymorphism.E02VehiclesExtended;

public class Truck extends Vehicle {
    private static final double AC_FUEL_CONSUMPTION_INCREASE = 1.6;
    private final double REFUELING_AMOUNT_FACTOR = 0.95;

    public Truck(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption + AC_FUEL_CONSUMPTION_INCREASE, tankCapacity);
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * REFUELING_AMOUNT_FACTOR);
    }
}
