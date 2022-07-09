package com.example.football.service;

import javax.xml.bind.JAXBException;

//ToDo - Implement all methods
public interface StatService {
    boolean areImported();

    String readStatsFileContent() ;

    String importStats() throws JAXBException;

}
