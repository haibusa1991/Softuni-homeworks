package com.example.football.util;

import java.io.BufferedReader;
import java.util.stream.Collectors;


public class FootballFileReader {
    public static String readFile(String filename) {

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filename));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception ignored) {
        }

        return null;
    }
}
