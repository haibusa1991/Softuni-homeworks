package L06DefiningClasses.E05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String engineModel = tokens[0];
            switch (tokens.length) {
                case 1:
                    engines.put(engineModel, new Engine(engineModel));
                    break;
                case 2:
                    try {
                        engines.put(engineModel, new Engine(engineModel, Integer.parseInt(tokens[1])));
                    } catch (Exception e) {
                        engines.put(engineModel, new Engine(engineModel, tokens[1]));
                    }
                    break;
                case 3:
                    try {
                        engines.put(engineModel, new Engine(engineModel, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
                    } catch (Exception e) {
                        engines.put(engineModel, new Engine(engineModel, Integer.parseInt(tokens[1]), tokens[2]));
                    }
                    break;
                case 4:
                    engines.put(engineModel, new Engine(engineModel, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]));
                    break;
            }
        }
        int m = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (m-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String carModel = tokens[0];
            Engine carEngine = engines.get(tokens[1]);
            switch (tokens.length) {
                case 2:
                    cars.add(new Car(carModel, carEngine));
                    break;
                case 3:
                    try {
                        cars.add(new Car(carModel, carEngine, Integer.parseInt(tokens[2])));
                    } catch (Exception e) {
                        cars.add(new Car(carModel, carEngine, tokens[2]));
                    }
                    break;
                case 4:
                    cars.add(new Car(carModel, carEngine, Integer.parseInt(tokens[2]), tokens[3]));
                    break;
            }
        }
        cars.forEach(System.out::println);
    }
}
