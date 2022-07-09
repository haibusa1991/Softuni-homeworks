package JsonEx.entities.product;

import java.math.BigDecimal;

public class SellingProductDto {
    private String name;
    private BigDecimal price;
    private String seller;

    public SellingProductDto(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellingProductDto that = (SellingProductDto) o;

        if (!name.equals(that.name)) return false;
        if (!price.equals(that.price)) return false;
        return seller.equals(that.seller);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + seller.hashCode();
        return result;
    }
}
