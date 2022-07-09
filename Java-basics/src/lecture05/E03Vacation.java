package lecture05;

import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double requiredMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int daysSpending = 0;
        int daysElapsed = 0;
        boolean canSave = true;

        while (requiredMoney > availableMoney) {

            String operation = scanner.nextLine();
            double sum = Double.parseDouble(scanner.nextLine());
            daysElapsed++;

            if (operation.equalsIgnoreCase("spend")) {
                availableMoney -= sum;
                if (availableMoney < 0) {
                    availableMoney = 0;
                }
                daysSpending++;
            }

            if (operation.equalsIgnoreCase("save")) {
                availableMoney += sum;
                daysSpending = 0;
            }

            if (daysSpending == 5) {
                System.out.printf("You can't save the money.\n%d", daysElapsed);
                canSave = false;
                break;
            }

        }

        if (canSave) {
            System.out.printf("You saved the money for %d days.", daysElapsed);
        }
    }
}
