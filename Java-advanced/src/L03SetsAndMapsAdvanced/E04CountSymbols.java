package L03SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> occurrences = new TreeMap<>();
        for (Character c : input.toCharArray()) {
            occurrences.putIfAbsent(c, 0);
            occurrences.put(c, occurrences.get(c) + 1);
        }
        occurrences.forEach((c,occ)->{
            System.out.println(c + ": " + occ + " time/s");
        });
    }
}
