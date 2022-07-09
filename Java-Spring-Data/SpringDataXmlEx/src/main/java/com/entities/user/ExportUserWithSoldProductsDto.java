package com.entities.user;


import com.entities.product.ExportSoldProductDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportUserWithSoldProductsDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    List<ExportSoldProductDto> products;

    public ExportUserWithSoldProductsDto(String firstName, String lastName, List<ExportSoldProductDto> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = products;
    }

    public ExportUserWithSoldProductsDto() {
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

    public List<ExportSoldProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ExportSoldProductDto> products) {
        this.products = products;
    }
}
