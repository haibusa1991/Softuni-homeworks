package L03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class E03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            elements.addAll(Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList()));
        }
        System.out.println(String.join(" ", elements));
    }
}
