package lecture06.ME02RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
//            <Model> - String, input[0]
//            <EngineSpeed> - int, input[1]
//            <EnginePower> - int, input[2]
//            <CargoWeight> - int, input[3]
//            <CargoType> - String, input[4]
//            <Tire1Pressure> - double, input[5]
//            <Tire1Age> - int, input[6]
//            <Tire2Pressure> - double, input[7]
//            <Tire2Age> - int, input[8]
//            <Tire3Pressure> - double, input[9]
//            <Tire3Age> - int, input[10]
//            <Tire4Pressure> - double, input[11]
//            <Tire4Age> - int, input[12]
            String model = input[0];
            Engine engine = new Engine(Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            List<Tyre> tires = new ArrayList<>();
            for (int j = 5; j <= 12; j += 2) {
                tires.add(new Tyre(Double.parseDouble(input[j]),
                        Integer.parseInt(input[j + 1])));
            }
            cars.add(new Car(model, engine, cargo, tires));
        }
        String filter = scanner.nextLine();
        if (filter.equals("fragile")) {
            cars.stream()
                    .filter(c -> c.getCargoType().equals(filter))
                    .filter(c -> c.getLowestTyrePressure() < 1)
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(car -> car.getCargoType().equals(filter))
                    .filter(car -> car.getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
