package L03SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E12LegendaryFarming {
    static Map<String, Integer> keyMaterials = new LinkedHashMap<>() {
        {
            put("fragments", 0);
            put("shards", 0);
            put("motes", 0);
        }
    };
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> junkMaterials = new LinkedHashMap<>();
        Set<String> keyMat = Set.of("motes", "shards", "fragments");
        boolean hasObtained = false;
        while (!hasObtained) {
            String[] input = reader.readLine().toLowerCase().split(" ");
            for (int i = 1; i < input.length; i += 2) {
                if (keyMat.contains(input[i])) {
                    keyMaterials.put(input[i], keyMaterials.get(input[i]) + Integer.parseInt(input[i - 1]));
                    if (hasObtainedLegendary()) {
                        hasObtained = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(input[i], 0);
                    junkMaterials.put(input[i], junkMaterials.get(input[i]) + Integer.parseInt(input[i - 1]));
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(k -> System.out.print(k.getKey() + ": " + k.getValue() + "\n"));
        junkMaterials.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(k -> System.out.print(k.getKey() + ": " + k.getValue() + "\n"));

    }

    private static boolean hasObtainedLegendary() {
        for (Map.Entry<String, Integer> val : keyMaterials.entrySet()) {
            if (val.getValue() >= 250) {
                switch (val.getKey()) {
                    case "fragments":
                        System.out.println("Valanyr obtained!");
                        break;
                    case "motes":
                        System.out.println("Dragonwrath obtained!");
                        break;
                    case "shards":
                        System.out.println("Shadowmourne obtained!");
                        break;
                }
                keyMaterials.put(val.getKey(), val.getValue() - 250);
                return true;
            }
        }
        return false;
    }
}
