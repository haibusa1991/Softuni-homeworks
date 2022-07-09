package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] values = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> customSort = (e1, e2) -> {
            if (e1 % 2 == 0 && e2 % 2 != 0) {
                return -1;
            } else if (e1 % 2 != 0 && e2 % 2 == 0) {
                return 1;
            } else
            return e1.compareTo(e2);
        };

        Arrays.stream(values).sorted(customSort).forEach(e -> System.out.print(e + " "));
    }
}
