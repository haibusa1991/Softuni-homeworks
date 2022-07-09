package softuni.exam.models.dto;

import softuni.exam.models.entity.ApartmentType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportDto {
    @XmlElement
    private ApartmentType apartmentType;

    @XmlElement
    private double area;

    @XmlElement
    private String town;

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public double getArea() {
        return area;
    }

    public String getTown() {
        return town;
    }
}
