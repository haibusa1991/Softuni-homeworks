package softuni.exam.models.dto.offer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportOfferDto {
    @XmlElement
    private BigDecimal price;

    @XmlElement
    private ImportOfferAgentDto agent;

    @XmlElement
    private ImportOfferApartmentIdDto apartment;

    @XmlElement(name = "publishedOn")
    private String publishDate;

    public BigDecimal getPrice() {
        return price;
    }

    public ImportOfferAgentDto getAgent() {
        return agent;
    }

    public ImportOfferApartmentIdDto getApartment() {
        return apartment;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
