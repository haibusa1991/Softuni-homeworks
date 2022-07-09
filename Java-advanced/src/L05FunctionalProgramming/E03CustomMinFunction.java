package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] values = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> findMin = e -> {
            int currentMin = Integer.MAX_VALUE;
            for (Integer val : e) {
                if (val < currentMin) {
                    currentMin = val;
                }
            }
            return currentMin;
        };
        System.out.println(findMin.apply(values));
    }
}
