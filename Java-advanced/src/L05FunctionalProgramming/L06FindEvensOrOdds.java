package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class L06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] values = new int[range[1] - range[0] + 1];
        for (int i = 0; i < values.length; i++) {
            values[i] = range[0] + i;
        }
        String inputType = scanner.nextLine();

        Predicate<Integer> type = e -> {
            if (inputType.equals("odd")) {
                return e % 2 != 0;
            } else {
                return e % 2 == 0;
            }
        };

        Consumer<Integer> printInt = e -> System.out.print(e + " ");

        Arrays.stream(values).boxed().filter(type).forEach(printInt);
    }
}
