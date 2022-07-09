package lecture07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        input.stream()
                .sorted((e1,e2)->e2.compareTo(e1))
                .limit(3)
                .collect(Collectors.toList())
                .forEach(e-> System.out.print(e + " "));
    }
}
