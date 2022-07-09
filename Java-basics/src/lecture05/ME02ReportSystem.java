package lecture05;

import java.util.Scanner;

public class ME02ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetSum = Integer.parseInt(scanner.nextLine());
        boolean isCash = true;
        int currentSum = 0;
        boolean isEnded = false;

        int cashSum = 0;
        int numCashTransactions = 0;
        int cardSum = 0;
        int numCardTransactions = 0;

        while (currentSum < targetSum) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("end")) {
                isEnded = true;
                break;
            }

            int currentValue = Integer.parseInt(input);

            if (isCash) {
                if (currentValue > 100) {
                    System.out.print("Error in transaction!\n");
                } else {
                    System.out.print("Product sold!\n");
                    currentSum += currentValue;
                    cashSum += currentValue;
                    numCashTransactions++;
                }
                isCash = false;

            } else {
                if (currentValue < 10) {
                    System.out.print("Error in transaction!\n");
                } else {
                    System.out.print("Product sold!\n");
                    currentSum += currentValue;
                    cardSum += currentValue;
                    numCardTransactions++;
                }
                isCash = true;
            }

        }
        if (isEnded) {
            System.out.print("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f\nAverage CC: %.2f", 1.0 * cashSum / numCashTransactions, 1.0 * cardSum / numCardTransactions);
        }

    }
}
