package L06DefiningClasses.L01CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (n-- > 0) {
            cars.add(new Car(scanner.nextLine()));
        }
        cars.forEach(Car::print);
    }
}
