package L04StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class E06WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\words.txt"));
        Map<String, Integer> words;
        words = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toMap(e -> e, e2 -> 0));
        br = new BufferedReader(new FileReader("D:\\Repos\\SoftUni\\Java-advanced\\src\\L04StreamsFilesAndDirectories\\ExerciseFiles\\text.txt"));
        String line = br.readLine();
        List<String> text = new ArrayList<>();
        while (line != null) {
            text.addAll(Arrays.asList(line.split(" ")));
            line = br.readLine();
        }
        for (String s : text) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            }
        }
        words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
