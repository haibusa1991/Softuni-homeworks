package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class L02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<String, Integer> parseInt = e -> Integer.parseInt(e);

        String[] numbers = scanner.nextLine().split(", ");
        Integer[] intNumbers = Arrays.stream(numbers).map(parseInt).toArray(Integer[]::new);

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + Arrays
                .stream(intNumbers)
                .mapToInt(e->e)
                .sum());
    }
}
