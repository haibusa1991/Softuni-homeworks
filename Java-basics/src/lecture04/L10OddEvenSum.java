package lecture04;

import java.util.Scanner;

public class L10OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());

            if (i % 2 == 0) {
                sumEven += value;
            } else {
                sumOdd += value;
            }
        }

        if (sumEven == sumOdd) {
            System.out.printf("Yes\nSum = %d", sumEven);
        } else {
            System.out.printf("No\nDiff = %d", Math.abs(sumEven - sumOdd));
        }
    }
}
