package com.example.football.service.impl;

import com.example.football.config.ApplicationBeanConfiguration;
import com.example.football.models.dto.player.PlayerImportDto;
import com.example.football.models.dto.player.PlayerImportListDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.FootballFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.football.util.Filenames.*;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    private final ModelMapper mapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TownRepository townRepository,
                             TeamRepository teamRepository,
                             StatRepository statRepository,
                             ModelMapper mapper) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() {
        return FootballFileReader.readFile(PLAYERS_FILEPATH);
    }

    @Override
    public String importPlayers() throws JAXBException {
        Unmarshaller unmarshaller = ApplicationBeanConfiguration.getUnmarshaller(PlayerImportListDto.class);
        PlayerImportListDto importDtos = (PlayerImportListDto) unmarshaller.unmarshal(new StringReader(readPlayersFileContent()));

        List<PlayerImportDto> dtos = importDtos.getPlayers();

        List<Player> players = dtos.stream()
                .map(this::fillData)
                .collect(Collectors.toList());

        List<String> results = new ArrayList<>();
        for (Player player : players) {
            try {
                this.playerRepository.save(player);
                results.add(String.format("Successfully imported Player %s %s - %s",
                        player.getFirstName(),
                        player.getLastName(),
                        player.getPosition().name()));
            } catch (Exception e) {
                results.add("Invalid Player");
            }
        }

        return String.join(System.lineSeparator(), results);
    }

    @Override
    public String exportBestPlayers() {
        List<Player> bestPlayers = this.playerRepository.getBestPlayers(
                LocalDate.of(1995, 1, 1),
                LocalDate.of(2003, 1, 1));

        StringBuilder sb = new StringBuilder();
        for (Player p : bestPlayers) {
            sb.append(String.format("""
                                    Player - %s %s
                                        Position - %s
                                        Team - %s
                                        Stadium - %s
                                    """,
                            p.getFirstName(), p.getLastName(),
                            p.getPosition().name(),
                            p.getTeam().getName(),
                            p.getTeam().getStadiumName()));
        }
        return sb.toString().trim();
    }

    private Player fillData(PlayerImportDto dto) {
        Player p = mapper.map(dto, Player.class);
        Town town = townRepository.getTownByName(dto.getTown().getName());
        Team team = teamRepository.getTeamByName(dto.getTeam().getName());
        Stat stat = statRepository.getById(dto.getStat().getId());

        p.setTown(town);
        p.setTeam(team);
        p.setStats(stat);

        return p;
    }
}
