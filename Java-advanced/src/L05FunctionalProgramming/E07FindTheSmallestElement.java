package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> min = e -> {
            int index = 0;
            int val = Integer.MAX_VALUE;
            for (int i = 0; i < e.length; i++) {
                if (e[i] <= val) {
                    val = e[i];
                    index = i;
                }
            }
            return index;
        };
        System.out.println(min.apply(values));
    }
}
