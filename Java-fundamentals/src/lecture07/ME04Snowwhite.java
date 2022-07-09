package lecture07;

import java.util.*;

public class ME04Snowwhite {
    static Map<String, Integer> dwarves = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {
            addDwarf(input);
            input = scanner.nextLine();
        }
        indexHats();
        printDwarves();
    }

    private static void addDwarf(String input) {
        String name = input.split(" <:> ")[0];
        String hatColor = input.split(" <:> ")[1];
        int physique = Integer.parseInt(input.split(" <:> ")[2]);
        String key = name + " <:> " + hatColor;
        dwarves.putIfAbsent(key, physique);
        if (dwarves.get(key) < physique) {
            dwarves.put(key, physique);
        }
    }

    private static void printDwarves() {
        dwarves.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingInt(e -> Integer.parseInt(e.getKey().split("К")[0]))
                        .reversed())
                .forEach(e -> {
                    System.out.printf("(%s) %s <-> %d%n",
//                        2КBlue <:> Ivan
                            e.getKey().split(" <:> ")[1],
                            e.getKey().split("К")[1].split(" <:> ")[0],
                            e.getValue());
                });
    }

    private static void indexHats() {
        Map<String, Integer> hatColors = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> currentDwarf : dwarves.entrySet()) {
            String hatColor = currentDwarf.getKey().split("<:>")[1];
            hatColors.putIfAbsent(hatColor, 0);
            if (hatColors.containsKey(hatColor)) {
                hatColors.put(hatColor, hatColors.get(hatColor) + 1);
            }
        }

        Map<String, Integer> indexedDwarves = new LinkedHashMap<>();
        for (Map.Entry<String,Integer> currentColor : hatColors.entrySet()){
            for (Map.Entry<String,Integer> currentDwarf: dwarves.entrySet()){
                if(currentDwarf.getKey().contains(currentColor.getKey())){
                    String dwarf = currentColor.getValue() + "К" + currentDwarf.getKey();
                    indexedDwarves.put(dwarf,currentDwarf.getValue());
                }
            }
        }
        dwarves = indexedDwarves;
    }
}
