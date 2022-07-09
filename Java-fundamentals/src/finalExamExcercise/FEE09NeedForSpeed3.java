package finalExamExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2307#2
public class FEE09NeedForSpeed3 {
    //    carName, mileage fuel
    static Map<String, String> cars = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\|");
            cars.put(data[0], data[1] + " " + data[2]);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String command = input.split(" : ")[0];
            String carName = input.split(" : ")[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(input.split(" : ")[2]);
                    int requiredFuel = Integer.parseInt(input.split(" : ")[3]);
                    if (getCarFuel(carName) < requiredFuel) {
                        System.out.println("Not enough fuel to make that ride");
                        break;
                    }
                    increaseCarMileage(carName, distance);
                    decreaseCarFuel(carName, requiredFuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, requiredFuel);
                    if (getCarMileage(carName) > 100000) {
                        System.out.println("Time to sell the " + carName +"!");
                        cars.remove(carName);
                    }
                    break;
                case "Refuel":
                    int fuelAmount = Integer.parseInt(input.split(" : ")[2]);
                    if (75 - getCarFuel(carName) < fuelAmount) {
                        int usedAmount = 75 - getCarFuel(carName);
                        setCarFuel(carName, 75);
                        System.out.printf("%s refueled with %d liters%n", carName, usedAmount);
                    } else {
                        System.out.printf("%s refueled with %d liters%n", carName, fuelAmount);
                        increaseCarFuel(carName, fuelAmount);
                    }
                    break;
                case "Revert":
                    int mileage = Integer.parseInt(input.split(" : ")[2]);
                    decreaseCarMileage(carName, mileage);
                    if (getCarMileage(carName) < 10000) {
                        setCarMileage(carName, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, mileage);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        cars.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = Integer.compare(Integer.parseInt(e2.getValue().split(" ")[0]),
                            Integer.parseInt(e1.getValue().split(" ")[0]));
                    if (res == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                })
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",e.getKey(),getCarMileage(e.getKey()),getCarFuel(e.getKey())));
    }

    private static int getCarFuel(String carName) {
        return Integer.parseInt(cars.get(carName).split(" ")[1]);
    }

    private static void setCarFuel(String carName, int amount) {
        String currentMileage = cars.get(carName).split(" ")[0];
        cars.put(carName, currentMileage + " " + amount);
    }

    private static void decreaseCarFuel(String carName, int amount) {
        String currentMileage = cars.get(carName).split(" ")[0];
        cars.put(carName, currentMileage + " " + (getCarFuel(carName) - amount));
    }

    private static void increaseCarFuel(String carName, int amount) {
        String currentMileage = cars.get(carName).split(" ")[0];
        cars.put(carName, currentMileage + " " + (getCarFuel(carName) + amount));
    }

    private static int getCarMileage(String carName) {
        return Integer.parseInt(cars.get(carName).split(" ")[0]);
    }

    private static void setCarMileage(String carName, int amount) {
        String currentFuel = cars.get(carName).split(" ")[1];
        cars.put(carName, amount + " " + currentFuel);
    }

    private static void increaseCarMileage(String carName, int amount) {
        String currentFuel = cars.get(carName).split(" ")[1];
        cars.put(carName, (getCarMileage(carName) + amount) + " " + currentFuel);
    }

    private static void decreaseCarMileage(String carName, int amount) {
        String currentFuel = cars.get(carName).split(" ")[1];
        cars.put(carName, (getCarMileage(carName) - amount) + " " + currentFuel);
    }


}
