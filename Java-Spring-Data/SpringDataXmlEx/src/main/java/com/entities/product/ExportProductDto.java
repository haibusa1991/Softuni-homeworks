package com.entities.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportProductDto {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    @XmlAttribute
    private String seller;

    public ExportProductDto() {
    }

    public ExportProductDto(String name, BigDecimal price, String sellerFirstName, String sellerLastName) {
        this.name = name;
        this.price = price;
        this.seller = sellerFirstName == null ? sellerLastName : sellerFirstName + " " + sellerLastName;
    }


}
