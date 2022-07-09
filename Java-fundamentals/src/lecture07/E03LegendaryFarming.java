package lecture07;

import java.util.*;

public class E03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new HashMap<>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};
        boolean hasObtainedItem = false;
        while (!hasObtainedItem) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 1; i < input.length; i += 2) {
                String currentItem = input[i].toLowerCase();
                int currentItemAmount = Integer.parseInt(input[i - 1]);
                if (items.containsKey(currentItem)) {
                    items.put(currentItem, items.get(currentItem) + currentItemAmount);
                } else {
                    items.put(currentItem, currentItemAmount);
                }

                if (items.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    items.put("shards", items.get("shards") - 250);
                    hasObtainedItem = true;
                    break;
                } else if (items.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    items.put("fragments", items.get("fragments") - 250);
                    hasObtainedItem = true;
                    break;
                } else if (items.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    items.put("motes", items.get("motes") - 250);
                    hasObtainedItem = true;
                    break;
                }
            }
        }
        items.entrySet()
                .stream()
                .filter(e -> e.getKey().equalsIgnoreCase("shards")
                        || e.getKey().equalsIgnoreCase("fragments")
                        || e.getKey().equalsIgnoreCase("motes"))
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        items.entrySet()
                .stream()
                .filter(e -> !e.getKey().equalsIgnoreCase("shards")
                        && !e.getKey().equalsIgnoreCase("fragments")
                        && !e.getKey().equalsIgnoreCase("motes"))
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
