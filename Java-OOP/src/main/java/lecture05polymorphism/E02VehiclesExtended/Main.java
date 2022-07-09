package lecture05polymorphism.E02VehiclesExtended;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> fleet = new LinkedHashMap<>();
        String[] tokens;

        for (int i = 0; i < 3; i++) {
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
                case "DriveEmpty":
                    if (currentVehicle instanceof Bus) {
                        ((Bus) currentVehicle).setIsDrivingEmpty(true);
                    }
                case "Drive":
                    try {
                        if (currentVehicle instanceof Bus && command.equals("Drive")) {
                            ((Bus) currentVehicle).setIsDrivingEmpty(false);
                        }

                        currentVehicle.drive(amount);
                        DecimalFormat df = new DecimalFormat("#.##");
                        System.out.printf("%s travelled %s km%n", currentVehicle.getClass().getSimpleName(), df.format(amount));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Refuel":
                    try {
                        currentVehicle.refuel(amount);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
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
        double tankCapacity = Double.parseDouble(tokens[3]);

        switch (type) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelAmount, fuelConsumption, tankCapacity);
            default:
                throw new IllegalArgumentException("No vehicle \"" + type + "\"");
        }
    }
}
