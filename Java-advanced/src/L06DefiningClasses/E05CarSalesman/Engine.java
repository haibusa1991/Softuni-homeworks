package L06DefiningClasses.E05CarSalesman;

public class Engine {
    private final String model;
    private final String power;
    private final String displacement;
    private final String efficiency;


    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power == -1
                ? "n/a"
                : power + "";
        this.displacement = displacement == -1
                ? "n/a"
                : displacement + "";
        this.efficiency = efficiency;
    }

    public Engine(String model) {
        this(model, -1, -1, "n/a");
    }

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, String efficiency) {
        this(model, -1, -1, efficiency);
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "Power: %s\n" +
                        "Displacement: %s\n" +
                        "Efficiency: %s",
                model, power, displacement, efficiency);
    }
}
