package Exam2;

import java.util.Scanner;

public class T05ChristmasGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int numAdults = 0;
        int numChildren = 0;
        while (!input.equalsIgnoreCase("Christmas")) {
            int value = Integer.parseInt(input);
            if (value <= 16) {
                numChildren++;
            } else {
                numAdults++;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Number of adults: %d\n" +
                "Number of kids: %d\n" +
                "Money for toys: %d\n" +
                "Money for sweaters: %d", numAdults, numChildren, numChildren * 5, numAdults * 15);
    }
}
