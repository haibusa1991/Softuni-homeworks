package lecture05polymorphism.E02VehiclesExtended;

public class Bus extends Vehicle {
    private boolean isEmpty = false;
    private static final double AC_FUEL_CONSUMPTION_INCREASE = 1.4;

    public Bus(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption + AC_FUEL_CONSUMPTION_INCREASE, tankCapacity);
    }

    public void setIsDrivingEmpty(boolean empty) {
        if (isEmpty == empty) {
            return;
        } else if (isEmpty) {
            super.setFuelConsumption(this.getFuelConsumption() + AC_FUEL_CONSUMPTION_INCREASE); // fills
        } else {
            super.setFuelConsumption(this.getFuelConsumption() - AC_FUEL_CONSUMPTION_INCREASE); // empties
        }
        isEmpty = empty;
    }
}
