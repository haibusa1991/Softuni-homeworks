package com.entities.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ImportProductDto {

    @XmlElement(name = "name")
    String name;

    @XmlElement(name = "price")
    String price;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
