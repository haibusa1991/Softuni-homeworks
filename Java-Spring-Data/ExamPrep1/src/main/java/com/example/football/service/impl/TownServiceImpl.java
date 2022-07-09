package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.FootballFileReader;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.football.util.Filenames.*;

//ToDo - Implement all methods
@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
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
    public String readTownsFileContent() {
        return FootballFileReader.readFile(TOWNS_FILEPATH);
    }

    @Override
    public String importTowns() {
        String json = readTownsFileContent();

        List<Town> towns = Arrays.stream(gson.fromJson(json, TownImportDto[].class))
                .map(e -> mapper.map(e, Town.class))
                .collect(Collectors.toList());

        List<String> results = new ArrayList<>();
        for (Town town : towns) {
            try {
                this.townRepository.save(town);
//                Successfully imported Town Moscow - 12195221
                results.add(String.format("Successfully imported Town %s - %d", town.getName(), town.getPopulation()));
            } catch (Exception e) {
                results.add("Invalid Town");
            }
        }

        return String.join(System.lineSeparator(), results);
    }
}
