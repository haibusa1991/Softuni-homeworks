package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class E05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] values = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> div = e -> e % n != 0;

        Consumer<Integer> print = e -> System.out.print(e + " ");

        UnaryOperator<Integer[]> reverse = e -> {
            Integer[] reversed = new Integer[e.length];
            for (int i = 0; i < reversed.length; i++) {
                reversed[i] = e[reversed.length - i - 1];
            }
            return reversed;
        };

        values = reverse.apply(values);
        Arrays.stream(values).filter(div).forEach(print);
    }
}
