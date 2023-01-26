package com.lab.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static String readFileFromDisk(String filepath) throws IOException {
       return String.join(System.lineSeparator(),Files.readAllLines(Path.of(filepath)));
    }
}
