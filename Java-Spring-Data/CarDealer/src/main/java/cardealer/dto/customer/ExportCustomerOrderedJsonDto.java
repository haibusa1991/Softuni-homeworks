package cardealer.dto.customer;

import cardealer.dto.sales.ExportSaleJsonDto;
import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.Set;

public class ExportCustomerOrderedJsonDto {

    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("BirthDate")
    private String birthDate;

    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;

    @SerializedName("Sales")
    private Set<ExportSaleJsonDto> sales;

    public ExportCustomerOrderedJsonDto() {
        this.sales = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public void setSales(Set<ExportSaleJsonDto> sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public Set<ExportSaleJsonDto> getSales() {
        return sales;
    }
}
