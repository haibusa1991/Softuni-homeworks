package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class L01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        String[] evens = Arrays
                .stream(values)
                .filter(e -> e % 2 == 0)
                .boxed()
                .map(String::valueOf)
                .toArray(String[]::new);
        System.out.println(String.join(", ", evens));

        String[] sorted = Arrays
                .stream(evens)
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .map(String::valueOf)
                .toArray(String[]::new);
        System.out.println(String.join(", ", sorted));


    }
}
