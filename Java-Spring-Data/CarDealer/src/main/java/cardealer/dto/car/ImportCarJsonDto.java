package cardealer.dto.car;

import java.math.BigInteger;

public class ImportCarJsonDto {
//    {"make":"Opel", "model":"Omega", "travelledDistance": 2147483647},

    private String make;
    private String model;
    protected String travelledDistance;

    public ImportCarJsonDto() {
    }

    public ImportCarJsonDto(String make, String model, String travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(String travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
