package lecture03;

import java.util.Scanner;

public class L13SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        days--;
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();

        double finalPrice = 0;

        switch (roomType) {
            case "room for one person":
                finalPrice = 18 * days;
                break;
            case "apartment":
                finalPrice = 25 * days;

                if (days < 10) {
                    finalPrice *= 0.7;
                } else if (days <= 15) {
                    finalPrice *= 0.65;
                } else {
                    finalPrice *= 0.5;
                }
                break;
            case "president apartment":
                finalPrice = 35 * days;

                if (days < 10) {
                    finalPrice *= 0.9;
                } else if (days <= 15) {
                    finalPrice *= 0.85;
                } else {
                    finalPrice *= 0.8;
                }
                break;
        }

        if (rating.equals("positive")) {
            finalPrice *= 1.25;
        } else {
            finalPrice *= 0.9;
        }
        System.out.printf("%.2f", finalPrice);
    }
}
