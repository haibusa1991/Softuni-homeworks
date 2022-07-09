package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.Filenames;
import softuni.exam.util.RealEstateUtils;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper mapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return RealEstateUtils.readFile(Filenames.TOWNS_FILE);
    }

    @Override
    public String importTowns() throws IOException {
        String json = readTownsFileContent();
        TownImportDto[] townImportDtos = this.gson.fromJson(new StringReader(json), TownImportDto[].class);

        List<String> results = new ArrayList<>();
        for (TownImportDto dto : townImportDtos) {
            Town town = this.mapper.map(dto, Town.class);
            try {

                this.townRepository.save(town);
                results.add(String.format("Successfully imported town %s - %d", town.getName(), town.getPopulation()));
            } catch (Exception e) {
                results.add("Invalid town");
            }
        }
        return String.join(System.lineSeparator(), results);
    }
}
