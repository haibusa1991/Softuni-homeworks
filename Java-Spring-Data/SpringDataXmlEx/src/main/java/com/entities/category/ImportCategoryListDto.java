package com.entities.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ImportCategoryListDto {

    @XmlElement(name = "category")
    List<ImportCategoryDto> categories;

    public ImportCategoryListDto() {
    }

    public List<ImportCategoryDto> getCategories() {
        return categories;
    }
}
