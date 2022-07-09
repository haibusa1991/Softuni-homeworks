package L06DefiningClasses.E03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String brand = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            cars.put(brand, new Car(brand, fuelAmount, consumption));
        }

        String driveInput = scanner.nextLine();
        while (!driveInput.equals("End")) {
            String[] tokens = driveInput.split(" ");
            String carToDrive = tokens[1];
            int distanceToTravel = Integer.parseInt(tokens[2]);
            cars.get(carToDrive).drive(distanceToTravel);
            driveInput = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }

}
