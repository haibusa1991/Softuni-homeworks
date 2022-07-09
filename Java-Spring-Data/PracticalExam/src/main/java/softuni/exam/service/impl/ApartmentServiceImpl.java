package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportDto;
import softuni.exam.models.dto.ApartmentImportListDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.Filenames;
import softuni.exam.util.RealEstateUtils;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ModelMapper mapper, TownRepository townRepository) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return RealEstateUtils.readFile(Filenames.APARTMENTS_FILE);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        String xml = readApartmentsFromFile();

        Unmarshaller unmarshaller = RealEstateUtils.getUnmarshaller(ApartmentImportListDto.class);
        assert unmarshaller != null;
        List<ApartmentImportDto> importDtos = ((ApartmentImportListDto) unmarshaller.unmarshal(new StringReader(xml))).getApartments();


        List<String> results = new ArrayList<>();
        for (ApartmentImportDto dto : importDtos) {
            Apartment apartment = this.mapper.map(dto, Apartment.class);
            apartment.setTown(this.townRepository.getTownByName(dto.getTown()));

            try {
                Apartment existing = this.apartmentRepository
                        .getApartmentByTownNameAndArea(apartment.getTown().getName(), apartment.getArea());

                if (existing!=null) {
                    throw new IllegalArgumentException();
                }

                this.apartmentRepository.save(apartment);
                results.add(String.format("Successfully imported apartment %s - %.2f",
                        apartment.getApartmentType().name(),
                        apartment.getArea()));
            } catch (Exception e) {
                results.add("Invalid apartment");
            }
        }

        return String.join(System.lineSeparator(), results);
    }
}
