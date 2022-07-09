package L03SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class E14DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Map<String, String>> dragons = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] input = reader.readLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = 45;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            int health = 250;
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            int armor = 10;
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }
            dragons.putIfAbsent(type, new TreeMap<>());
            Map<String, String> currentTypeDragons = dragons.get(type);
            String stats = ("damage: " + damage + ", health: " + health + ", armor: " + armor);
            currentTypeDragons.put(name, stats);
            dragons.put(type, currentTypeDragons);
        }
        dragons.forEach((type, currentDragons) -> {
            System.out.println(type + "::" + getAverages(currentDragons));
            currentDragons.forEach((d, s) -> System.out.println("-" + d + " -> " + s));
        });
    }

    private static String getAverages(Map<String, String> dragons) {
        double damage = 0;
        double health = 0;
        double armor = 0;
        for (Map.Entry<String, String> dragon : dragons.entrySet()) {
            int[] stats = Arrays.stream(dragon.getValue()
                            .replace("damage: ", "")
                            .replace("health: ", "")
                            .replace("armor: ", "")
                            .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            damage += stats[0];
            health += stats[1];
            armor += stats[2];
        }
        damage /= dragons.size();
        health /= dragons.size();
        armor /= dragons.size();
        return String.format("(%.2f/%.2f/%.2f)", damage, health, armor);
    }
}
