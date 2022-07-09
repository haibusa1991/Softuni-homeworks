package L04StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class L06SortLines {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\input.txt"));
        FileWriter fw = new FileWriter("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\06.SortLinesOutput.txt");
        lines.stream().sorted().forEach(e-> {
            try {
                fw.write(e+System.lineSeparator());
                fw.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
