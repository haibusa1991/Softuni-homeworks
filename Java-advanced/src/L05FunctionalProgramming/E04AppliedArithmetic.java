package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class E04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        UnaryOperator<Integer[]> add = e -> {
            for (int i = 0; i < e.length; i++) {
                e[i] += 1;
            }
            return e;
        };

        UnaryOperator<Integer[]> multiply = e -> {
            for (int i = 0; i < e.length; i++) {
                e[i] *= 2;
            }
            return e;
        };

        UnaryOperator<Integer[]> subtract = e -> {
            for (int i = 0; i < e.length; i++) {
                e[i] -= 1;
            }
            return e;
        };

        Consumer<Integer[]> print = e -> System.out.println(Arrays.toString(e).replaceAll("[\\[,\\]]", ""));

        String action = scanner.nextLine();
        while (!action.equals("end")) {
            switch (action) {
                case "add":
                    add.apply(numbers);
                    break;
                case "multiply":
                    multiply.apply(numbers);
                    break;
                case "subtract":
                    subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }
            action = scanner.nextLine();
        }
    }
}
