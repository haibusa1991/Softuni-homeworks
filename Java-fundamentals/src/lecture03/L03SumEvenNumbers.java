package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class L03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sum = 0;
        for (int currentNumber : numbers) {
            if (currentNumber % 2 == 0) {
                sum += currentNumber;
            }
        }
        System.out.println(sum);
    }
}
