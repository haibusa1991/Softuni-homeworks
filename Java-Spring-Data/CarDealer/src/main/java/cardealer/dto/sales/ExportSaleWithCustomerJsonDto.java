package cardealer.dto.sales;

import cardealer.dto.car.ExportCarJsonDto;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ExportSaleWithCustomerJsonDto {
    private ExportCarJsonDto car;
    private String customerName;
    @SerializedName("Discount")
    private double discount;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;

    public ExportSaleWithCustomerJsonDto() {
    }

    public ExportCarJsonDto getCar() {
        return car;
    }

    public void setCar(ExportCarJsonDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
