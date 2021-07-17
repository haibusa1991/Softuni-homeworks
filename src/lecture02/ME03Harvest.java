package lecture02;

import java.util.Scanner;

public class ME03Harvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int area = Integer.parseInt(sc.nextLine());
        double grapesYield = Double.parseDouble(sc.nextLine());
        int wineDemand = Integer.parseInt(sc.nextLine());
        int numOfWorkers = Integer.parseInt(sc.nextLine());

        double areaForWine = area * .4;
        double grapes = areaForWine * grapesYield;
        double wineYield = grapes / 2.5;

        if (wineYield < wineDemand) {
            System.out.printf("It will be a tough winter! More %d liters wine needed.", (int) Math.floor(wineDemand - wineYield));
        } else {
            System.out.printf("Good harvest this year! Total wine: %d liters.\n" +
                            "%d liters left -> %d liters per person.",
                    (int) Math.floor(wineYield),
                    (int) Math.ceil(wineYield - wineDemand), (int) Math.ceil((wineYield - wineDemand) / numOfWorkers));
        }
    }

}
