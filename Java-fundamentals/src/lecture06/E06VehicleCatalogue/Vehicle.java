package lecture06.E06VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private double power;

    public Vehicle(String type, String model, String color, double power) {
        setType(type);
        this.model = model;
        this.color = color;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public double getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("car")) {
            this.type = "Car";
        } else {
            this.type = "Truck";
        }
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f", type, model, color, power);

    }
}
