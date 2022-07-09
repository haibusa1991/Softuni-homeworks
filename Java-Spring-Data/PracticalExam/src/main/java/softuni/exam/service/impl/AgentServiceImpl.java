package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.Filenames;
import softuni.exam.util.RealEstateUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    public AgentServiceImpl(AgentRepository agentRepository, TownRepository townRepository, Gson gson, ModelMapper mapper) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return RealEstateUtils.readFile(Filenames.AGENTS_FILE);
    }

    @Override
    public String importAgents() throws IOException {
        String json = readAgentsFromFile();
        AgentImportDto[] importDtos = this.gson.fromJson(json, AgentImportDto[].class);

        List<String> results = new ArrayList<>();
        for (AgentImportDto dto : importDtos) {
            Agent agent = this.mapper.map(dto, Agent.class);
            Town town = this.townRepository.getTownByName(dto.getTown());
            agent.setTown(town);

            try {
                this.agentRepository.save(agent);
                results.add(String.format("Successfully imported agent - %s %s",
                        agent.getFirstName(),
                        agent.getLastName()));
            } catch (Exception e) {
                results.add("Invalid agent");
            }
        }

        return String.join(System.lineSeparator(), results);
    }
}
