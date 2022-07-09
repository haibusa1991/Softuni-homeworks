package lecture06.E06VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();
        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equalsIgnoreCase("end")) {
                break;
            }
            vehicles.add(new Vehicle(input[0], input[1], input[2], Double.parseDouble(input[3])));
        }

        while (true) {
            String input2 = scanner.nextLine();
            if (input2.equalsIgnoreCase("Close the Catalogue")) {
                break;
            }
            for (Vehicle v : vehicles) {
                if (v.getModel().equals(input2)) {
                    System.out.println(v);
                    break;
                }
            }
        }

        double averageCarPower = vehicles.stream()
                .filter(v -> v.getType().equals("Car"))
                .mapToDouble(Vehicle::getPower)
                .average()
                .orElse(0);

        double averageTruckPower = vehicles.stream()
                .filter(e -> e.getType().equals("Truck"))
                .mapToDouble(Vehicle::getPower)
                .average()
                .orElse(0);

        System.out.printf("Cars have average horsepower of: %.2f.\nTrucks have average horsepower of: %.2f.", averageCarPower, averageTruckPower);
    }
}




