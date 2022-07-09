package L04StreamsFilesAndDirectories;

import java.io.*;
import java.util.Arrays;
import java.util.function.Predicate;

public class L04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\LabFiles\\input.txt"));
        String line = br.readLine();
        Predicate<String> isInt = p ->{
            for(char c : p.toCharArray()){
                if(!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        };

        while (line != null) {
            if (line.length() != 0) {
                Arrays.stream(line.split(" "))
                        .filter(k->!k.isEmpty())
                        .filter(isInt)
                        .forEach(System.out::println);
            }
            line = br.readLine();
        }
    }
}
