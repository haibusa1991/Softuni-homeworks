package JsonEx.entities.user;

import java.math.BigDecimal;

public class BuyerDto {
    private String buyerFirstName;
    private String buyerLastName;
    private BigDecimal productPrice;
    private String productName;

    public BuyerDto(String firstName, String lastName, BigDecimal productPrice, String productName) {
        this.buyerFirstName = firstName;
        this.buyerLastName = lastName;
        this.productPrice = productPrice;
        this.productName = productName;
    }

    public BuyerDto() {
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
