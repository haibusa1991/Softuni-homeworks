package L06DefiningClasses.E03SpeedRacing;

public class Car {
    private final String model;
    private int mileage = 0;
    private double fuelAmount;
    private final double consumption;

    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = consumption;
    }

    public void drive(int distance) {
        double fuelRequired = distance * consumption;
        if (fuelRequired > fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            fuelAmount -= fuelRequired;
            mileage += distance;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",model,fuelAmount,mileage);
    }
}
