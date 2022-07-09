package com.entities.product;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportProductNamePriceListDto {

    @XmlAttribute
    private int count;

    @XmlElement (name = "product")
//    @XmlElementWrapper
    private List<ExportProductNamePriceDto> soldProducts;

    public ExportProductNamePriceListDto() {
    }

    public ExportProductNamePriceListDto(int count, List<ExportProductNamePriceDto> soldProducts) {
        this.count = count;
        this.soldProducts = soldProducts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ExportProductNamePriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ExportProductNamePriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
