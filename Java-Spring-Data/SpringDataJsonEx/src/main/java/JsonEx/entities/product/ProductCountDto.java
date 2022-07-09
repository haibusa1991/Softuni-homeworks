package JsonEx.entities.product;

import java.math.BigDecimal;

public class ProductCountDto {
    private String category;
    private long count;
    private double averagePrice;
    private BigDecimal totalRevenue;

    public ProductCountDto(String category, long count, double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.count = count;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public ProductCountDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
