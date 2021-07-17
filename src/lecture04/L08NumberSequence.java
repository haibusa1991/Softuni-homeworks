package lecture04;

import java.util.Scanner;

public class L08NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());

            if (value > maxNumber) {
                maxNumber = value;
            }

            if (value < minNumber) {
                minNumber = value;
            }
        }
        System.out.printf("Max number: %d\nMin number: %d", maxNumber, minNumber);
    }
}
