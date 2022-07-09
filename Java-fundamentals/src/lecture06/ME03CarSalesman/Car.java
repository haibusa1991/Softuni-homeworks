package lecture06.ME03CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight = "n/a";
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        setWeight(weight);
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        setWeight(weight);
        this.color = color;
    }

    private void setWeight(int weight) {
        this.weight = Integer.toString(weight);
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "  %s\n" +
                        "  Weight: %s\n" +
                        "  Color: %s",
                model,
                engine,
                weight,
                color);
    }
}
