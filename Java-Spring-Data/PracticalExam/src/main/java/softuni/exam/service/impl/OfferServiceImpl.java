package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.offer.ImportOfferDto;
import softuni.exam.models.dto.offer.ImportOfferListDto;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.Filenames;
import softuni.exam.util.RealEstateUtils;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper mapper;

    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return RealEstateUtils.readFile(Filenames.OFFERS_FILE);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        String xml = readOffersFileContent();

        Unmarshaller unmarshaller = RealEstateUtils.getUnmarshaller(ImportOfferListDto.class);

        assert unmarshaller != null;
        List<ImportOfferDto> importDtos = ((ImportOfferListDto) unmarshaller.unmarshal(new StringReader(xml))).getOffers();

        List<String> results = new ArrayList<>();
        for (ImportOfferDto dto : importDtos) {
            Offer offer = this.mapper.map(dto, Offer.class);
            offer.setApartment(this.apartmentRepository.getById((long) dto.getApartment().getId()));
            offer.setAgent(this.agentRepository.getAgentByFirstName(dto.getAgent().getName()));

            try {
                this.offerRepository.save(offer);
                results.add(String.format("Successfully imported offer %.2f", offer.getPrice()));
            } catch (Exception e) {
                results.add("Invalid offer");
            }

        }

        return String.join(System.lineSeparator(), results);
    }

    @Override
    @Transactional
    public String exportOffers() {
        List<Offer> bestOffers = this.offerRepository.getBestOffers(ApartmentType.three_rooms);

        List<String> results = new ArrayList<>();

        for (Offer offer : bestOffers) {
            results.add(String.format("""
                            Agent %s %s with offer №%d:
                                -Apartment area: %.2f
                                --Town: %s
                                ---Price: %.2f$""",
                    offer.getAgent().getFirstName(),
                    offer.getAgent().getLastName(),
                    offer.getId(),
                    offer.getApartment().getArea(),
                    offer.getApartment().getTown().getName(),
                    offer.getPrice()
            ));
        }
        return String.join(System.lineSeparator(), results);
    }
}
