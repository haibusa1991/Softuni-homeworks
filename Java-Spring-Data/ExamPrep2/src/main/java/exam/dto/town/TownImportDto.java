package exam.dto.town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportDto {

    @XmlElement
    private String name;

    @XmlElement
    private int population;

    @XmlElement(name = "travel-guide")
    private String travelGuide;

    public TownImportDto() {
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }
}
