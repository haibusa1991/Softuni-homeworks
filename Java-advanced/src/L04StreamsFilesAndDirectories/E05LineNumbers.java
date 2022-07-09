package L04StreamsFilesAndDirectories;

import java.io.*;

public class E05LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\inputLineNumbers.txt"));
        String line = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter("outputL04-E05.txt"));
        int lineNum = 1;
        while (line != null) {
            bw.write(lineNum + ". " + line + System.lineSeparator());
            lineNum++;
            line = br.readLine();
        }
        bw.close();
    }
}
