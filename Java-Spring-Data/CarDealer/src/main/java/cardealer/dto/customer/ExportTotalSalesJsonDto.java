package cardealer.dto.customer;

import java.math.BigDecimal;

public class ExportTotalSalesJsonDto {
    private String fullName;
    private int boughtCars;
    private BigDecimal spentMoney;

    public ExportTotalSalesJsonDto() {
        this.spentMoney = BigDecimal.ZERO;
    }

    public ExportTotalSalesJsonDto(String fullName, int boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
