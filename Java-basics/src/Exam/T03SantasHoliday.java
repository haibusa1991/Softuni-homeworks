package Exam;

import java.util.Scanner;

public class T03SantasHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNights = Integer.parseInt(scanner.nextLine());
        numNights -= 1;
        String roomType = scanner.nextLine();
        String feedback = scanner.nextLine();
        boolean isRatingPositive = feedback.equalsIgnoreCase("positive");

        double finalPrice = 0;

        switch (roomType) {
            case "room for one person":
                finalPrice = numNights * 18;
                break;
            case "apartment":
                finalPrice = numNights * 25;
                if (numNights < 10) {
                    finalPrice *= 0.7;
                } else if (numNights <= 15) {
                    finalPrice *= 0.65;
                } else {
                    finalPrice *= 0.5;
                }

                break;
            case "president apartment":
                finalPrice = numNights * 35;
                if (numNights < 10) {
                    finalPrice *= 0.9;
                } else if (numNights <= 15) {
                    finalPrice *= 0.85;
                } else {
                    finalPrice *= 0.8;
                }


        }

        if (isRatingPositive) {
            finalPrice *= 1.25;
        } else {
            finalPrice *= 0.9;
        }

        System.out.printf("%.2f", finalPrice);

    }
}
