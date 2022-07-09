package L06DefiningClasses.E05CarSalesman;

public class Car {
    private final String model;
    private final Engine engine;
    private final String weight;
    private final String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight == -1
                ? "n/a"
                : weight + "";
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "%s\n" +
                        "Weight: %s\n" +
                        "Color: %s",
                model, engine, weight, color);
    }
}
