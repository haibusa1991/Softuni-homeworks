package com.entities.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportProductDtoList {

    @XmlElement(name = "product")
    private List<ExportProductDto> productDtos;

    public void setProductDtos(List<ExportProductDto> productDtos) {
        this.productDtos = productDtos;
    }
}
