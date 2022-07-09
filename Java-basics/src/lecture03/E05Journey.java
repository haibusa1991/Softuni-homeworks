package lecture03;

import java.util.Scanner;

public class E05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        boolean isWinter = season.equals("winter");

        String location;
        String site;
        double moneySpent;

        if (budget <= 100) {
            location = "Bulgaria";
            if (isWinter) {
                moneySpent = budget * 0.7;
                site = "Hotel";
            } else {
                moneySpent = budget * 0.3;
                site = "Camp";
            }
        } else if (budget <= 1000) {
            location = "Balkans";
            if (isWinter) {
                moneySpent = 0.8 * budget;
                site = "Hotel";
            } else {
                moneySpent = 0.4 * budget;
                site = "Camp";
            }
        } else {
            location = "Europe";
            moneySpent = 0.9 * budget;
            site = "Hotel";
        }
        System.out.printf("Somewhere in %s\n%s - %.2f", location, site, moneySpent);
    }
}
