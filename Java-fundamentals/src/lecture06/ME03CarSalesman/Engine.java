package lecture06.ME03CarSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement = "n/a";//optional
    private String efficiency = "n/a";//optional

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }


    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        setDisplacement(displacement);
    }


    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
    }


    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        setDisplacement(displacement);
        this.efficiency = efficiency;
    }

    private void setDisplacement(int displacement) {
        this.displacement = Integer.toString(displacement);
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "    Power: %d\n" +
                        "    Displacement: %s\n" +
                        "    Efficiency: %s",
                model,
                power,
                displacement,
                efficiency);
    }
}
