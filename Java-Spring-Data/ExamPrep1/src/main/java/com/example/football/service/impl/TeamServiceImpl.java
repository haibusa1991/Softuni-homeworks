package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, Gson gson, ModelMapper mapper) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
    }


    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() {
        return FootballFileReader.readFile(TEAMS_FILEPATH);
    }

    @Override
    public String importTeams() {
        String json = readTeamsFileContent();
        List<Team> teams = Arrays.stream(gson.fromJson(json, TeamImportDto[].class))
                .map(this::importTeam)
                .collect(Collectors.toList());

        List<String> results = new ArrayList<>();

        for (Team team : teams) {
            try {
                this.teamRepository.save(team);
                results.add(String.format("Successfully imported Team %s - %d", team.getName(), team.getFanBase()));
            } catch (Exception e) {
                results.add("Invalid Team");
            }
        }

        return String.join(System.lineSeparator(), results);
    }

    private Team importTeam(TeamImportDto dto) {
        Team town = mapper.map(dto, Team.class);
        town.setTown(this.townRepository.getTownByName(dto.getTownName()));
        return town;
    }
}
