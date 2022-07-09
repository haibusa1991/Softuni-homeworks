package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class E09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> divisors = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        BiFunction<Integer, Set<Integer>, Boolean> isDividable = (number, list) -> {
            for (Integer num : list) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= n; i++) {
            if (isDividable.apply(i, divisors)) {
                System.out.print(i + " ");
            }

        }
    }


}
