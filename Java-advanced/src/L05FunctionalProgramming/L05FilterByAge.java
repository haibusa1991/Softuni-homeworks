package L05FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class L05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> people = new ArrayList<>();
        while (n-- > 0) {
            people.add(scanner.nextLine());
        }
        String filterCategory = scanner.nextLine();
        int filterAge = Integer.parseInt(scanner.nextLine());
        String filterType = scanner.nextLine();

        Predicate<String> ageFilter = e -> {
            String[] values = e.split(", ");
            if (filterCategory.equals("older")) {
                return Integer.parseInt(values[1]) >= filterAge;
            } else {
                return Integer.parseInt(values[1]) <= filterAge;
            }
        };

        Consumer<String> printType = e -> {
            String[] values = e.split(", ");
            if (filterType.equals("name age")) {
                System.out.println(values[0] + " - " + values[1]);
            } else if (filterType.equals("name")) {
                System.out.println(values[0]);
            } else {
                System.out.println(values[1]);
            }
        };

        people.stream()
                .filter(ageFilter)
                .forEach(printType);
    }
}
