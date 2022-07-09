package lecture04;

import java.util.Scanner;

public class L05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String good = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", getPrice(good, quantity));
    }

    static double getPrice(String good, int quantity) {
        double price = 0;
        switch (good) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }
        return price * quantity;
    }
}
