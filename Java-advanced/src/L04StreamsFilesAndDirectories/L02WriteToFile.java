package L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Set;

public class L02WriteToFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\input.txt");
        InputStreamReader iso = new InputStreamReader(fis);
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\02.WriteToFileOutput.txt"));
        int currentChar = fis.read();
        Set<Character> chars = Set.of(',', '.', '!', '?');
        while (currentChar != 65535) {
            if (!chars.contains((char) currentChar)) {
                bw.write(currentChar);
            }
            currentChar = (char) iso.read();
        }
        bw.close();
    }
}
