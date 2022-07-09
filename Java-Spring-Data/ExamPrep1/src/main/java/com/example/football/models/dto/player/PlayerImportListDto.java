package com.example.football.models.dto.player;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportListDto {

    @XmlElement(name = "player")
    private List<PlayerImportDto> players;

    public List<PlayerImportDto> getPlayers() {
        return players;
    }
}
