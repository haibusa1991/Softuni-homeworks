package lecture03;

import java.util.Scanner;

public class L11FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double finalPrice = 0;
        boolean isInvalidInput = false;
        boolean isWeekend = false;

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                break;
            case "Saturday":
            case "Sunday":
                isWeekend = true;
                break;
            default:
                isInvalidInput = true;
                break;
        }

        double bananaPrice = 2.5;
        double applePrice = 1.2;
        double orangePrice = 0.85;
        double grapefruitPrice = 1.45;
        double kiwiPrice = 2.7;
        double pineapplePrice = 5.5;
        double grapesPrice = 3.85;

        if (isWeekend) {
            bananaPrice = 2.7;
            applePrice = 1.25;
            orangePrice = 0.9;
            grapefruitPrice = 1.6;
            kiwiPrice = 3;
            pineapplePrice = 5.6;
            grapesPrice = 4.2;
        }

        switch (fruit) {
            case "banana":
                finalPrice = quantity * bananaPrice;
                break;
            case "apple":
                finalPrice = quantity * applePrice;
                break;
            case "orange":
                finalPrice = quantity * orangePrice;
                break;
            case "grapefruit":
                finalPrice = quantity * grapefruitPrice;
                break;
            case "kiwi":
                finalPrice = quantity * kiwiPrice;
                break;
            case "pineapple":
                finalPrice = quantity * pineapplePrice;
                break;
            case "grapes":
                finalPrice = quantity * grapesPrice;
                break;
            default:
                isInvalidInput = true;
                break;
        }

        if (isInvalidInput) {
            System.out.println("error");
        } else {
            System.out.printf("%.2f",finalPrice);
        }
    }
}
