package lecture03;

import java.util.Scanner;

public class ME03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfChrysanthemum = Integer.parseInt(scanner.nextLine());
        int numOfRose = Integer.parseInt(scanner.nextLine());
        int numOfTulip = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        boolean isHoliday = holiday.equals("Y");

        double chrysanthemumPrice = 2;
        double rosePrice = 4.1;
        double tulipPrice = 2.5;

        if (season.equals("Autumn") || season.equals("Winter")) {
            chrysanthemumPrice = 3.75;
            rosePrice = 4.5;
            tulipPrice = 4.15;
        }

        double price = numOfChrysanthemum * chrysanthemumPrice +
                numOfRose * rosePrice +
                numOfTulip * tulipPrice;

        if (isHoliday) {
            price *= 1.15;
        }

        if (numOfTulip > 7 && season.equals("Spring")) {
            price *= 0.95;
        }
        if (numOfRose >= 10 && season.equals("Winter")) {
            price *= 0.9;
        }

        if (numOfChrysanthemum + numOfRose + numOfTulip > 20) {
            price *= 0.8;
        }

        System.out.printf("%.2f", 2 + price);


    }
}
