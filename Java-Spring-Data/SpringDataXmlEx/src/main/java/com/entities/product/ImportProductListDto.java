package com.entities.product;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProductListDto {

    @XmlElement(name = "product")
    private List<ImportProductDto> productDtos;

    public ImportProductListDto() {
    }

    public List<ImportProductDto> getProductDtos() {
        return productDtos;
    }
}
