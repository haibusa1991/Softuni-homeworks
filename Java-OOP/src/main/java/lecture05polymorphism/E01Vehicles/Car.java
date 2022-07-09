package lecture05polymorphism.E01Vehicles;

public class Car extends Vehicle {
    private static final double AC_FUEL_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuel, double fuelConsumption) {
        super(fuel, fuelConsumption + AC_FUEL_CONSUMPTION_INCREASE);
    }
}
