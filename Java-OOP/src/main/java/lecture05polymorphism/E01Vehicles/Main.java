package lecture05polymorphism.E01Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> fleet = new HashMap<>();
        String[] tokens;

        for (int i = 0; i < 2; i++) {
            tokens = scanner.nextLine().split(" ");
            fleet.put(tokens[0], createVehicle(tokens));
        }

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] commandTokens = scanner.nextLine().split(" ");
            String command = commandTokens[0];
            String vehicle = commandTokens[1];
            double amount = Double.parseDouble(commandTokens[2]);

            Vehicle currentVehicle = fleet.get(vehicle);
            switch (command) {
                case "Drive":
                    System.out.println(currentVehicle.drive(amount));
                    break;
                case "Refuel":
                    currentVehicle.refuel(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown command \"" + command + "\"");
            }
        }
        fleet.values().forEach(System.out::println);

    }

    private static Vehicle createVehicle(String[] tokens) {
        String type = tokens[0];
        double fuelAmount = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);

        switch (type) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption);
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption);
            default:
                throw new IllegalArgumentException("No vehicle \"" + type + "\"");
        }
    }
}
