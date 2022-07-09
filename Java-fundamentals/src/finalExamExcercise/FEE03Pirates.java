package finalExamExcercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2302#2

public class FEE03Pirates {
    //    cityName,   gold||population
    static Map<String, String> cities = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateCities();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains("Plunder")) {
                plunder(input);
            } else {
                prosper(input);
            }
            input = scanner.nextLine();
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        int res = Integer.compare(Integer.parseInt(e2.getValue().split("\\|\\|")[0]), Integer.parseInt(e1.getValue().split("\\|\\|")[0]));
                        if (res == 0) {
                            return e1.getKey().compareTo(e2.getKey());
                        } else {
                            return res;
                        }
                    })
                    .forEach(e -> {
                        String city = e.getKey();
                        String gold = e.getValue().split("\\|\\|")[0];
                        String population = e.getValue().split("\\|\\|")[1];
                        System.out.printf("%s -> Population: %s citizens, Gold: %s kg%n", city, population, gold);
                    });
        }
    }

    private static void prosper(String input) {
        String[] data = input.split("=>");
        String cityName = data[1];
        int gold = Integer.parseInt(data[2]);
        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
            return;
        }
        int currentGold = Integer.parseInt(cities.get(cityName).split("\\|\\|")[0]) + gold;
        int currentPopulation = Integer.parseInt(cities.get(cityName).split("\\|\\|")[1]);
        cities.put(cityName, currentGold + "||" + currentPopulation);
        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",gold,cityName,currentGold);
    }

    private static void plunder(String input) {
        String[] data = input.split("=>");
        String cityName = data[1];
        int population = Integer.parseInt(data[2]);
        int gold = Integer.parseInt(data[3]);
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, gold, population);
        int currentGold = Integer.parseInt(cities.get(cityName).split("\\|\\|")[0]) - gold;
        int currentPopulation = Integer.parseInt(cities.get(cityName).split("\\|\\|")[1]) - population;
        if (currentGold == 0 || currentPopulation == 0) {
            System.out.printf("%s has been wiped off the map!%n", cityName);
            cities.remove(cityName);
        } else {
            cities.put(cityName, currentGold + "||" + currentPopulation);
        }

    }

    private static void populateCities() {
        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] data = input.split("\\|\\|");
            String cityName = data[0];
            int population = Integer.parseInt(data[1]);
            int gold = Integer.parseInt(data[2]);

            if (cities.containsKey(cityName)) {
                int currentGold = Integer.parseInt(cities.get(cityName).split("\\|\\|")[0]) + gold;
                int currentPopulation = Integer.parseInt(cities.get(cityName).split("\\|\\|")[1]) + population;
                cities.put(cityName, currentGold + "||" + currentPopulation);
            }
            cities.putIfAbsent(cityName, gold + "||" + population);
            input = scanner.nextLine();
        }
    }
}
