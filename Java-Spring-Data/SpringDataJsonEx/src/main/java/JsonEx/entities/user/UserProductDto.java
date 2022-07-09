package JsonEx.entities.user;

import JsonEx.entities.product.ProductPriceDto;

import java.util.Set;

public class UserProductDto {
    private String firstName;
    private String lastName;
    private int age;
    private Set<ProductPriceDto> soldProducts;

    public UserProductDto() {
    }

    public UserProductDto(String firstName, String lastName, int age, Set<ProductPriceDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = soldProducts;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<ProductPriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductPriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
