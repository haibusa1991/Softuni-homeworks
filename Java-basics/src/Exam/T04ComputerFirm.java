package Exam;

import java.util.Scanner;

public class T04ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numComputers = Integer.parseInt(scanner.nextLine());

        double totalRating = 0;
        double totalSales = 0;
        for (int i = 0; i < numComputers; i++) {
            int currentComputer = Integer.parseInt(scanner.nextLine());

            int rating = currentComputer % 10;
            int possibleSales = currentComputer / 10;

            switch (rating) {
                case 3:
                    totalSales += possibleSales * 0.5;
                    break;
                case 4:
                    totalSales += possibleSales * 0.7;
                    break;
                case 5:
                    totalSales += possibleSales * 0.85;
                    break;
                case 6:
                    totalSales += possibleSales;
                    break;
            }
            totalRating += rating;
        }
        System.out.printf("%.2f\n%.2f", totalSales, totalRating / numComputers);
    }
}
