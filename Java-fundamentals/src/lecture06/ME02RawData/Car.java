package lecture06.ME02RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tyre> tyres;

    public Car(String model, Engine engine, Cargo cargo, List<Tyre> tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    @Override
    public String toString() {
        return model;
    }

    public String getCargoType() {
        return cargo.toString();
    }

    public double getLowestTyrePressure() {
        return tyres.stream()
                .mapToDouble(Tyre::getPressure)
                .min()
                .orElse(0);
    }

    public int getPower() {
        return engine.getPower();
    }
}
