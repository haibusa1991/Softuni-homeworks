package lecture02;

import java.util.Scanner;

public class E06GodzillaVsKong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        int numOfExtras = Integer.parseInt(sc.nextLine());
        double extraClothingPrice = Double.parseDouble(sc.nextLine());

        double setPrice = budget*.1;
        double extrasPrice = numOfExtras*extraClothingPrice;

        if (numOfExtras>150){
            extrasPrice*=.9;
        }

        double totalExpenses = extrasPrice+setPrice;
        double difference = Math.abs(totalExpenses-budget);

        if(totalExpenses>budget){
            System.out.printf("Not enough money!\nWingard needs %.2f leva more.",difference);
        } else {
            System.out.printf("Action!\nWingard starts filming with %.2f leva left.",difference);
        }
    }
}
