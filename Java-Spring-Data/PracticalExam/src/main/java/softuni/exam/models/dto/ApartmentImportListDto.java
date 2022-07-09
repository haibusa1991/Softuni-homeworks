package softuni.exam.models.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentImportListDto {

    @XmlElement(name = "apartment")
    private List<ApartmentImportDto> apartments;

    public List<ApartmentImportDto> getApartments() {
        return apartments;
    }
}
