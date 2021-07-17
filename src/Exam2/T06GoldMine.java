package Exam2;

import java.util.Scanner;

public class T06GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLocations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numLocations; i++) {
            double expectedYield = Double.parseDouble(scanner.nextLine());
            int digDays = Integer.parseInt(scanner.nextLine());

            double yield = 0;
            for (int j = 0; j < digDays; j++) {
                yield += Double.parseDouble(scanner.nextLine());
            }

            if (expectedYield <= yield/digDays) {
                System.out.printf("Good job! Average gold per day: %.2f.\n", yield / digDays);
            } else {
                System.out.printf("You need %.2f gold.\n", expectedYield - yield / digDays);
            }
        }
    }
}
