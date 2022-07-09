package cardealer.dto.sales;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ExportSaleJsonDto {
    @SerializedName("Id")
    private int id;

    @SerializedName("Car make")
    private String carMake;

    @SerializedName("Car model")
    private String carModel;

    @SerializedName("Car price")
    private BigDecimal carPrice;

    @SerializedName("Sale price")
    private BigDecimal salePrice;

    public ExportSaleJsonDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
