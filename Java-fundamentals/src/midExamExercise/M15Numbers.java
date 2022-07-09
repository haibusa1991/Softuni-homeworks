package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2474#2

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M15Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> initialNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double average = initialNumbers
                .stream()
                .mapToDouble(e -> e)
                .average()
                .orElse(0);

        List<Integer> topIntegers = initialNumbers
                .stream()
                .filter(e -> e > average)
                .sorted()
                .collect(Collectors.toList());
        Collections.reverse(topIntegers);
        while (topIntegers.size() > 5) {
            topIntegers.remove(topIntegers.size() - 1);
        }

        if (topIntegers.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println(topIntegers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
