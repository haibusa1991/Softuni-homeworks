package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatImportDto {

    @XmlElement (name = "passing")
    private double passing;

    @XmlElement (name = "shooting")
    private double shooting;

    @XmlElement (name = "endurance")
    private double endurance;

    public double getPassing() {
        return passing;
    }

    public double getShooting() {
        return shooting;
    }

    public double getEndurance() {
        return endurance;
    }
}
