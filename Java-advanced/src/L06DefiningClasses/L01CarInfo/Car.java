package L06DefiningClasses.L01CarInfo;

public class Car {
    private final String brand;
    private final String model;
    private final int power;

    public Car(String input) {
        String[] tokens = input.split(" ");
        this.brand = tokens[0];
        this.model = tokens[1];
        this.power = Integer.parseInt(tokens[2]);
    }

    public void print() {
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, power);
    }
}