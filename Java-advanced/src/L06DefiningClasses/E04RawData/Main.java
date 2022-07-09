package L06DefiningClasses.E04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            int enginePower = Integer.parseInt(tokens[2]);
            String cargoType = tokens[4];
            List<Double> tyrePressures = new ArrayList<>();
            for (int i = 5; i < 11; i += 2) {
                tyrePressures.add(Double.parseDouble(tokens[i]));
            }
            cars.add(new Car(model, enginePower, cargoType, tyrePressures));
        }
        String cargoFilter = scanner.nextLine();
        if (cargoFilter.equals("fragile")) {
            cars.stream()
                    .filter(e -> e.getCargoType().equals("fragile"))
                    .filter(e -> e.getMinimumTyrePressure() < 1)
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(e -> e.getCargoType().equals("flamable"))
                    .filter(e -> e.getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
