package com.example.football.models.dto.player;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportStatDto {

    @XmlElement
    private int id;

    public int getId() {
        return id;
    }
}
