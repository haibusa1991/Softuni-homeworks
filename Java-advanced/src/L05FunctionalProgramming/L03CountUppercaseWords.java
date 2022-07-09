package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class L03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Predicate<String> isUppercase = e -> Character.isUpperCase(e.charAt(0));

        String[] uppercase = Arrays
                .stream(input)
                .filter(isUppercase)
                .toArray(String[]::new);
        System.out.println(uppercase.length);
        Arrays.stream(uppercase).forEach(System.out::println);
    }
}
