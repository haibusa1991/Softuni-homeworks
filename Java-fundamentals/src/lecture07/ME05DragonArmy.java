package lecture07;

import java.util.*;

public class ME05DragonArmy {
    static Map<String, TreeMap<String, String>> dragons = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numDragons = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numDragons; i++) {
            addDragon(scanner.nextLine());
        }
        printDragons();
    }

    private static void addDragon(String input) {
        String[] data = input.split(" ");
//        0{type} 1{name} 2{damage} 3{health} 4{armor}.
        String type = data[0];
        String name = data[1];
        if (data[2].equals("null")) data[2] = "45";
        if (data[3].equals("null")) data[3] = "250";
        if (data[4].equals("null")) data[4] = "10";
        int damage = Integer.parseInt(data[2]);
        int health = Integer.parseInt(data[3]);
        int armor = Integer.parseInt(data[4]);
        dragons.putIfAbsent(type, new TreeMap<>());
        Map<String, String> currentDragon = dragons.get(type);
        currentDragon.put(name, damage + " " + health + " " + armor);
    }

    private static void printDragons() {
        dragons.entrySet()
                .forEach(e -> {
                    System.out.printf("%s::(%s)%n", e.getKey(), getAverages(e.getValue()));
                    e.getValue().entrySet().forEach(w -> {
                        String[] data = w.getValue().split(" ");
                        int damage = Integer.parseInt(data[0]);
                        int health = Integer.parseInt(data[1]);
                        int armor = Integer.parseInt(data[2]);
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", w.getKey(), damage, health, armor);
                    });
                });
    }

    private static String getAverages(Map<String, String> dragons) {
        int numDragons = dragons.size();
        double damage = 0;
        double health = 0;
        double armor = 0;
        for (Map.Entry<String, String> currentDragon : dragons.entrySet()) {
            damage += Double.parseDouble(currentDragon.getValue().split(" ")[0]);
            health += Double.parseDouble(currentDragon.getValue().split(" ")[1]);
            armor += Double.parseDouble(currentDragon.getValue().split(" ")[2]);
        }
        damage /= numDragons;
        health /= numDragons;
        armor /= numDragons;
        return String.format("%.2f/%.2f/%.2f", damage, health, armor);
    }
}
