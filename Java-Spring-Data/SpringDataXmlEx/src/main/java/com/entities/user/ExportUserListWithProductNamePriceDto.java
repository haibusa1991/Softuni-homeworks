package com.entities.user;

import com.entities.product.ExportProductNamePriceListDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportUserListWithProductNamePriceDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private int age;

    @XmlElement(name = "sold-products")
    ExportProductNamePriceListDto soldProducts;

    public ExportUserListWithProductNamePriceDto() {
    }

    public ExportUserListWithProductNamePriceDto(String firstName, String lastName, int age, ExportProductNamePriceListDto soldProducts) {
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

    public ExportProductNamePriceListDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ExportProductNamePriceListDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
