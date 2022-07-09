package finalExamExcercise;
//https://judge.softuni.bg/Contests/Practice/Index/2518#2

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FEE12PlantDiscovery {
    //    plantName,rarity rating
    static Map<String, String> plants = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("<->");
            plants.put(data[0], data[1] + " ");
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] data = input.split(": ")[1].split(" - ");
            String plantName = data[0];
            if (!plants.containsKey(plantName)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }
            switch (input.split(": ")[0]) {
                case "Rate": {
                    int value = Integer.parseInt(data[1]);
                    addRating(plantName, value);
                    break;
                }
                case "Update": {
                    int value = Integer.parseInt(data[1]);
                    updateRarity(plantName, value);
                    break;
                }
                case "Reset":
                    resetRating(plantName);
                    break;
                default:
                    System.out.println("error");
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = Integer.compare(getRarity(e2.getKey()), getRarity(e1.getKey()));
                    if (res == 0) {
                        return Double.compare(getRating(e2.getKey()), getRating(e1.getKey()));
                    }
                    return res;
                })
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), getRarity(e.getKey()), getRating(e.getKey())));
    }

    private static int getRarity(String plantName) {
        return Integer.parseInt(plants.get(plantName).split(" ")[0]);
    }

    private static double getRating(String plantName) {
        String[] data = plants.get(plantName).split(" ");
        if (data.length == 2) {
            return Arrays.stream(Arrays.stream(data[1].split(","))
                    .mapToDouble(Double::parseDouble)
                    .toArray())
                    .average()
                    .orElse(0);
        } else {
            return 0;
        }
    }

    private static void resetRating(String plantName) {
        String rarity = plants.get(plantName).split(" ")[0];
        plants.put(plantName, rarity + " 0");
    }

    private static void updateRarity(String plantName, int value) {
        String[] data = plants.get(plantName).split(" ");
        if (data.length == 2) {
            plants.put(plantName, value + " " + data[1]);
        } else {
            plants.put(plantName, value + " ");
        }
    }

    private static void addRating(String plantName, int value) {
        if (plants.get(plantName).charAt(plants.get(plantName).length() - 1) == ' ') {
            String rarity = plants.get(plantName).split(" ")[0];
            plants.put(plantName, rarity + " " + value + ",");
        } else {
            StringBuilder ratings = new StringBuilder(plants.get(plantName).split(" ")[1]);
            String rarity = plants.get(plantName).split(" ")[0] + " ";
            ratings.insert(0, rarity).append(value).append(",");
            plants.put(plantName, ratings.toString());
        }
    }
}
