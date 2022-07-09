package L08IteratorsAndComparators.E04Froggy;

import L08IteratorsAndComparators.Iterators.Lake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lake lake = new Lake(Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray());
        scanner.nextLine();

        List<String> output=new ArrayList<>();
        for (Integer integer : lake) {
            output.add(integer+"");
        }
        System.out.println(String.join(", ", output));
    }
}
