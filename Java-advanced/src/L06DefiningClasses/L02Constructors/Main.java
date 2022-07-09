package L06DefiningClasses.L02Constructors;

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
            Car currentCar;
            switch (tokens.length) {
                case 1:
                    try {
                        currentCar = new Car(tokens[0]);
                    } catch (Exception e) {
                        currentCar = new Car(Integer.parseInt(tokens[0]));
                    }
                    break;
                case 2:
                    try {
                        currentCar = new Car(tokens[0], tokens[1]);
                    } catch (Exception e) {
                        currentCar = new Car(tokens[0], Integer.parseInt(tokens[1]));
                    }
                    break;
                default:
                    currentCar = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                    break;
            }
            cars.add(currentCar);
        }
        cars.forEach(Car::print);
    }
}
