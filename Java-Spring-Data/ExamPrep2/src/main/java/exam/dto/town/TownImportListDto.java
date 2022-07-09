package exam.dto.town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportListDto {

    @XmlElement(name = "town")
    private List<TownImportDto> towns;

    public TownImportListDto() {
    }

    public List<TownImportDto> getTowns() {
        return towns;
    }
}
