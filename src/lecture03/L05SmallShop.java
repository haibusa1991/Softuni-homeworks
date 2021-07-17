package lecture03;

import java.util.Scanner;

public class L05SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double coffeePrice = 0.5;
        double waterPrice = 0.8;
        double beerPrice = 1.2;
        double sweetsPrice = 1.45;
        double peanutsPrice = 1.60;

        double productPrice = 0;

        switch (city) {
            case "Plovdiv":
                coffeePrice = 0.4;
                waterPrice = 0.7;
                beerPrice = 1.15;
                sweetsPrice = 1.3;
                peanutsPrice = 1.5;
                break;
            case "Varna":
                coffeePrice = 0.45;
                waterPrice = 0.7;
                beerPrice = 1.1;
                sweetsPrice = 1.35;
                peanutsPrice = 1.55;
                break;
        }

        switch (product) {
            case "coffee":
                productPrice = coffeePrice * quantity;
                break;
            case "water":
                productPrice = waterPrice * quantity;
                break;
            case "beer":
                productPrice = beerPrice * quantity;
                break;
            case "sweets":
                productPrice = sweetsPrice * quantity;
                break;
            case "peanuts":
                productPrice = peanutsPrice * quantity;
                break;
        }

        System.out.println(productPrice);

    }
}
