package lecture06;

import java.util.Scanner;

public class L04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = Integer.parseInt(scanner.nextLine());
        int upperBound = Integer.parseInt(scanner.nextLine());
        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean hasFoundNumber = false;
        int currentCombination = 0;

        for (int i = lowerBound; i <= upperBound; i++) {
            for (int j = lowerBound; j <= upperBound; j++) {
                currentCombination++;
                if (i + j == numberToFind) {
                    System.out.printf("Combination N:%d (%d + %d = %d)\n", currentCombination, i, j, numberToFind);
                    hasFoundNumber = true;
                    break;
                }
            }
            if (hasFoundNumber) {
                break;
            }
        }

        if (!hasFoundNumber) {
            System.out.printf("%d combinations - neither equals %d", currentCombination, numberToFind);
        }
    }

}
