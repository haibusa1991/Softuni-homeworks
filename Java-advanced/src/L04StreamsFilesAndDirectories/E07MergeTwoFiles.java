package L04StreamsFilesAndDirectories;

import java.io.*;

public class E07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\inputOne.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("outputL04-E07.txt"));
        String line1 = br.readLine();
        while (line1 != null) {
            bw.write(line1 + System.lineSeparator());
            line1 = br.readLine();
        }
        br.close();
        br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\inputTwo.txt"));
        String line2 = br.readLine();
        while (line2 != null) {
            bw.write(line2 + System.lineSeparator());
            line2 = br.readLine();
        }
        br.close();
        bw.close();
    }
}
