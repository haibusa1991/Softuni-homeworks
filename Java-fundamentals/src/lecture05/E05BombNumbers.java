package lecture05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");
        int bomb = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber == bomb) {
                for (int j = 0; j < power; j++) {
                    if (i - 1 - j >= 0) numbers.set(i - 1 - j, Integer.MIN_VALUE);
                    if (i + 1 + j < numbers.size()) numbers.set(i + 1 + j, Integer.MIN_VALUE);
                }
                numbers.set(i, Integer.MIN_VALUE);
            }
        }
        while (numbers.contains(Integer.MIN_VALUE)) {
            numbers.remove(Integer.valueOf(Integer.MIN_VALUE));
        }

        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }

}