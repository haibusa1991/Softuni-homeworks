package L06DefiningClasses.E07Google;

public class Car {
    public String model;
    public int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", model, speed);
    }
}
