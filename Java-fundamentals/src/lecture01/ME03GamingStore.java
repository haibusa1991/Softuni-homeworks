package lecture01;

import java.util.Scanner;

public class ME03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = (int) Math.round(Double.parseDouble(scanner.nextLine()) * 100);
        String currentTitle = scanner.nextLine();
        int totalSpent = 0;
        while (!currentTitle.equals("Game Time")) {
            int price = 0;
            switch (currentTitle) {
                case "RoverWatch Origins Edition":
                case "OutFall 4":
                    price = 3999;
                    break;
                case "CS: OG":
                    price = 1599;
                    break;
                case "Zplinter Zell":
                    price = 1999;
                    break;
                case "Honored 2":
                    price = 5999;
                    break;
                case "RoverWatch":
                    price = 2999;
                    break;
            }
            if (price != 0) {
                if (budget >= price) {
                    totalSpent += price;
                    budget -= price;
                    System.out.printf("Bought %s\n", currentTitle);
                } else {
                    System.out.println("Too Expensive");
                }
            } else {
                System.out.println("Not Found");
            }

            if (budget == 0) {
                System.out.println("Out of money!");
                return;
            }

            currentTitle = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent / 100.00, budget / 100.00);
    }
}
