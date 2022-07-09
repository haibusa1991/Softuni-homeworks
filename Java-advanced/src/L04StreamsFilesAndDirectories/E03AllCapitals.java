package L04StreamsFilesAndDirectories;

import java.io.*;

public class E03AllCapitals {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("outputL04-E03.txt"));
        String line=br.readLine();
        while (line!=null){
            bw.write(line.toUpperCase()+System.lineSeparator());
            line=br.readLine();
        }
        bw.close();
    }
}
