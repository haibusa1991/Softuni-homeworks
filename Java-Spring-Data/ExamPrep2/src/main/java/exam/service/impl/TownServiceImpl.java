package exam.service.impl;

import exam.config.ApplicationBeanConfiguration;
import exam.model.Town;
import exam.dto.town.TownImportDto;
import exam.dto.town.TownImportListDto;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.Filenames;
import exam.util.LaptopShopFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper mapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper) {
        this.townRepository = townRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() {
        return LaptopShopFileReader.readFile(Filenames.TOWNS_FILE);
    }

    @Override
    public String importTowns() throws JAXBException {
        String xml = readTownsFileContent();
        Unmarshaller unmarshaller = ApplicationBeanConfiguration.getUnmarshaller(TownImportListDto.class);

        assert unmarshaller != null;
        TownImportListDto importDtos = (TownImportListDto) unmarshaller.unmarshal(new StringReader(xml));

        List<String> results = new ArrayList<>();
        for (TownImportDto dto : importDtos.getTowns()) {
            Town town = mapper.map(dto, Town.class);
            try {
                this.townRepository.save(town);
                results.add(String.format("Successfully imported Town %s", town.getName()));
            } catch (Exception e) {
                results.add("Invalid town");
            }
        }

        return String.join(System.lineSeparator(), results);
    }
}
