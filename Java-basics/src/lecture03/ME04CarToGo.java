package lecture03;

import java.util.Scanner;

public class ME04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String car;
        String carClass;
        double carBudget;

        if (budget <= 100) {
            carClass = "Economy class";
            if (season.equals("Summer")) {
                car = "Cabrio";
                carBudget = 0.35;
            } else {
                car = "Jeep";
                carBudget = 0.65;
            }
        } else if (budget <= 500) {
            carClass = "Compact class";
            if (season.equals("Summer")) {
                car = "Cabrio";
                carBudget = 0.45;
            } else {
                car = "Jeep";
                carBudget = 0.8;
            }
        } else {
            carClass = "Luxury class";
            car = "Jeep";
            carBudget = 0.9;
        }
        System.out.printf("%s\n%s - %.2f", carClass, car, carBudget * budget);
    }
}
