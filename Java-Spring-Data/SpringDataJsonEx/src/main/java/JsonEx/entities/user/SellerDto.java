package JsonEx.entities.user;

import java.util.Set;

public class SellerDto {
    private String firstName;
    private String lastName;

    Set<BuyerDto> soldProducts;

    public SellerDto(String firstName, String lastName, Set<BuyerDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }

    public SellerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<BuyerDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<BuyerDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
