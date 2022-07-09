package L04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E01SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\input.txt"));
        String line = br.readLine();
        while (line != null) {
            int sum = 0;
            for (char c : line.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
            line = br.readLine();
        }
    }
}
