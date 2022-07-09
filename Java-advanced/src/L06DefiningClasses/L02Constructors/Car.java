package L06DefiningClasses.L02Constructors;

public class Car {
    private final String brand;
    private final String model;
    private final int power;

    public Car(String brand, String model, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
    }

    public Car(String brand, String model) {
        this(brand, model, -1);
    }

    public Car(int power) {
        this("unknown", "unknown", power);
    }

    public Car(String brand, int power) {
        this(brand, "unknown", power);
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public void print() {
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, power);
    }
}
