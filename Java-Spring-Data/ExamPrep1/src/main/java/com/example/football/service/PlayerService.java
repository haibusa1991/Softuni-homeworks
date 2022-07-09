package com.example.football.service;

import javax.xml.bind.JAXBException;

//ToDo - Implement all methods
public interface PlayerService {
    boolean areImported();

    String readPlayersFileContent() ;

    String importPlayers() throws JAXBException;

    String exportBestPlayers();
}
