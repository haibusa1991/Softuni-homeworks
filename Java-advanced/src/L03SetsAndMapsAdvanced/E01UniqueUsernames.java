package L03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> input = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            input.add(scanner.nextLine());
        }
        input.forEach(System.out::println);
    }
}
