package softuni.exam.models.dto.offer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportOfferListDto {

    @XmlElement(name = "offer")
    private List<ImportOfferDto> offers;

    public List<ImportOfferDto> getOffers() {
        return offers;
    }
}
