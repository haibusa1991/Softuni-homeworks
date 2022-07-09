package Exam2;

import java.util.Scanner;

public class T02BeerAndChips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fanName = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int numBeers = Integer.parseInt(scanner.nextLine());
        int numChips = Integer.parseInt(scanner.nextLine());

        double beerPrice = numBeers * 1.2;
        int chipsPrice = (int) Math.ceil(beerPrice * 0.45 * numChips);

        double finalPrice = beerPrice + chipsPrice;

        if (finalPrice <= budget) {
            System.out.printf("%s bought a snack and has %.2f leva left.", fanName, budget - finalPrice);
        } else {
            System.out.printf("%s needs %.2f more leva!", fanName, finalPrice - budget);
        }
    }
}
