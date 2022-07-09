package lecture04;

import java.util.Scanner;

public class ME03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCargos = Integer.parseInt(scanner.nextLine());
        int totalCargoWeight = 0;

        int vanCargo = 0;
        int truckCargo = 0;
        int trainCargo = 0;

        for (int i = 0; i < numCargos; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());
            totalCargoWeight += cargoWeight;
            if (cargoWeight <= 3) {
                vanCargo += cargoWeight;
            } else if (cargoWeight <= 11) {
                truckCargo += cargoWeight;
            } else {
                trainCargo += cargoWeight;
            }
        }
        double averagePrice = (vanCargo * 200 + truckCargo * 175 + trainCargo * 120) * 1.0 / totalCargoWeight;

        System.out.printf("%.2f\n", averagePrice);
        System.out.printf("%.2f%%\n", 1.0 * vanCargo / totalCargoWeight * 100);
        System.out.printf("%.2f%%\n", 1.0 * truckCargo / totalCargoWeight * 100);
        System.out.printf("%.2f%%\n", 1.0 * trainCargo / totalCargoWeight * 100);

    }
}
