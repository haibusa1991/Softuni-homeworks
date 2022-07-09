package lecture06.ME03CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            engines.add(addEngine(data));
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] data = scanner.nextLine().split(" ");
            cars.add(addCar(data, engines));
        }

        for (Car car : cars) {
            System.out.println(car);
        }


    }

    private static Engine addEngine(String[] data) {
        switch (data.length) {
            case 2:
                return new Engine(data[0], Integer.parseInt(data[1]));
            case 3:
                if (Character.isDigit(data[2].charAt(0))) {
                    return new Engine(data[0],
                            Integer.parseInt(data[1]),
                            Integer.parseInt(data[2]));
                } else {
                    return new Engine(data[0],
                            Integer.parseInt(data[1]),
                            data[2]);
                }
            case 4:
                return new Engine(data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        data[3]);
        }
        return null;
    }

    private static Car addCar(String[] data, List<Engine> engines) {
        switch (data.length) {
            case 2:
                return new Car(data[0], getEngineByModel(data[1], engines));
            case 3:
                if (Character.isDigit(data[2].charAt(0))) {
                    return new Car(data[0],
                            getEngineByModel(data[1], engines),
                            Integer.parseInt(data[2]));
                } else {
                    return new Car(data[0],
                            getEngineByModel(data[1], engines),
                            data[2]);
                }
            case 4:
                return new Car(data[0],
                        getEngineByModel(data[1], engines),
                        Integer.parseInt(data[2]),
                        data[3]);
        }
        return null;
    }

    private static Engine getEngineByModel(String model, List<Engine> engines) {
        return engines.stream().filter(e -> e.getModel().equals(model)).collect(Collectors.toList()).get(0);
    }
}