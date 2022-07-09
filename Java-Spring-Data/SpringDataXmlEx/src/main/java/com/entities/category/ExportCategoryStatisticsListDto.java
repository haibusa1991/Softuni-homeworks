package com.entities.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportCategoryStatisticsListDto {

    @XmlElement(name = "category")
    private List<ExportCategoryStatisticsDto> categories;

    public ExportCategoryStatisticsListDto() {
    }

    public ExportCategoryStatisticsListDto(List<ExportCategoryStatisticsDto> categories) {
        this.categories = categories;
    }

    public List<ExportCategoryStatisticsDto> getCategories() {
        return categories;
    }

    public void setCategories(List<ExportCategoryStatisticsDto> categories) {
        this.categories = categories;
    }
}
