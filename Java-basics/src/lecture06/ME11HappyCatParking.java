package lecture06;

import java.util.Scanner;

public class ME11HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;
        for (int i = 1; i <= days; i++) {
            double dailySum = 0;
            for (int j = 1; j <= hours; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    dailySum += 2.5;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    dailySum += 1.25;
                } else {
                    dailySum += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva\n", i, dailySum);
            totalSum += dailySum;
        }
        System.out.printf("Total: %.2f leva",totalSum);
    }
}
