package com.example.football.models.dto.player;

import com.example.football.models.entity.Position;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportDto {
    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement
    private Position position;

    @XmlElement
    private PlayerImportTownDto town;

    @XmlElement
    private PlayerImportTeamDto team;

    @XmlElement
    private PlayerImportStatDto stat;

    public PlayerImportDto() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PlayerImportTownDto getTown() {
        return town;
    }

    public void setTown(PlayerImportTownDto town) {
        this.town = town;
    }

    public PlayerImportTeamDto getTeam() {
        return team;
    }

    public void setTeam(PlayerImportTeamDto team) {
        this.team = team;
    }

    public PlayerImportStatDto getStat() {
        return stat;
    }

    public void setStat(PlayerImportStatDto stat) {
        this.stat = stat;
    }
}
