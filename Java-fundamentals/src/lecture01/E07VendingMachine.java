package lecture01;

import java.util.Scanner;

public class E07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coinInput = scanner.nextLine();
        int availableSum = 0;
        while (!coinInput.equals("Start")) {
            int stotinki = (int) (Double.parseDouble(coinInput) * 100);
            switch (stotinki) {
                case 10:
                case 20:
                case 50:
                case 100:
                case 200:
                    availableSum += stotinki;
                    break;
                default:
                    System.out.printf("Cannot accept %.2f\n", Double.parseDouble(coinInput));
            }
            coinInput = scanner.nextLine();
        }
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            int productPrice = 0;
            switch (product) {
                case "Nuts":
                    productPrice = 200;
                    break;
                case "Water":
                    productPrice = 70;
                    break;
                case "Crisps":
                    productPrice = 150;
                    break;
                case "Soda":
                    productPrice = 80;
                    break;
                case "Coke":
                    productPrice = 100;
                    break;
            }
            if (productPrice != 0) {
                if (productPrice <= availableSum) {
                    availableSum -= productPrice;
                    System.out.printf("Purchased %s\n", product);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", 1.0 * availableSum / 100);
    }
}
