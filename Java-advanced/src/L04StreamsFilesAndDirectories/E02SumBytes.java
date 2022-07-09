package L04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E02SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\input.txt"));
        long c = br.read();
        long sum = 0;
        while (c != -1) {
            if (c != 10 && c != 13) {
                sum += c;
            }
            c = br.read();
        }
        System.out.println(sum);
    }
}

