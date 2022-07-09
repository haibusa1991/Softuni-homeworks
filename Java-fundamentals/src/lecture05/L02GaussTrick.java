package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int extent = input.size() / 2;
        for (int i = 0; i < extent; i++) {
            input.set(i, input.get(i) + input.get(input.size() - 1));
            input.remove(input.size() - 1);
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }
}
