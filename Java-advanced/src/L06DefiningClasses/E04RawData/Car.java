package L06DefiningClasses.E04RawData;

import java.util.List;

public class Car {
    private final String model;
    private final int enginePower;
    private final String cargoType;
    private final List<Double> tyrePressures;

    public Car(String model, int enginePower, String cargoType, List<Double> tyrePressures) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.tyrePressures = tyrePressures;
    }

    public String getCargoType() {
        return cargoType;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public double getMinimumTyrePressure() {
        return tyrePressures.stream()
                .mapToDouble(e -> e)
                .min()
                .orElse(0);
    }

    @Override
    public String toString() {
        return model;
    }
}
