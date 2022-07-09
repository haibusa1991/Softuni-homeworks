package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class L05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int oddSum = 0;
        int evenSum = 0;
        for (int currentNumber : numbers) {
            if (currentNumber % 2 == 0) {
                evenSum += currentNumber;
            } else {
                oddSum += currentNumber;
            }
        }
        System.out.println(evenSum - oddSum);

    }
}
