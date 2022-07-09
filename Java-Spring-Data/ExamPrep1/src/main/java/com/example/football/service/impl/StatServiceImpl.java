package com.example.football.service.impl;

import com.example.football.config.ApplicationBeanConfiguration;
import com.example.football.models.dto.StatImportList;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.FootballFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.football.util.Filenames.*;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final ModelMapper mapper;


    @Autowired
    public StatServiceImpl(StatRepository statRepository, ModelMapper mapper) {
        this.statRepository = statRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() {
        return FootballFileReader.readFile(STATS_FILEPATH);
    }

    @Override
    public String importStats() throws JAXBException {

        StatImportList importDtos = (StatImportList) ApplicationBeanConfiguration.getUnmarshaller(StatImportList.class)
                .unmarshal(new StringReader(readStatsFileContent()));

        List<Stat> dtos = importDtos.getStats()
                .stream()
                .map(e -> mapper.map(e, Stat.class))
                .collect(Collectors.toList());

        List<String> results = new ArrayList<>();

        for (Stat dto : dtos) {
            Stat existing = statRepository
                    .getByPassingAndShootingAndEndurance(
                            dto.getPassing(),
                            dto.getShooting(),
                            dto.getEndurance()
                    );

            if (existing != null) {
                results.add("Invalid Stat");
                continue;
            }

            try {
                this.statRepository.save(dto);
                results.add(String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                        dto.getPassing(),
                        dto.getShooting(),
                        dto.getEndurance()));
            } catch (Exception e) {
                results.add("Invalid Stat");
            }
        }

        return String.join(System.lineSeparator(), results);
    }
}
