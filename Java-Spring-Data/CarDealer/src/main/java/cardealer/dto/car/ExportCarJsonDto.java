package cardealer.dto.car;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class ExportCarJsonDto {

    @SerializedName("Id")
    private int id;

    @SerializedName("Make")
    private String make;

    @SerializedName("Model")
    private String model;

    @SerializedName("TravelledDistance")
    private BigInteger distance;

    public ExportCarJsonDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigInteger getDistance() {
        return distance;
    }

    public void setDistance(BigInteger distance) {
        this.distance = distance;
    }
}
