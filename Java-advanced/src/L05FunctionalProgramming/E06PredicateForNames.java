package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");

        Predicate<String> len = e->e.length()<=n;

        Arrays.stream(names).filter(len).forEach(System.out::println);
    }
}
