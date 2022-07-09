package finalExamExcercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/1444#1
public class FEE16SantasNewList {
    static Map<String, Integer> children = new LinkedHashMap<>();
    static Map<String, Integer> presents = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            if (input.contains("Remove")) {
                children.remove(input.split("->")[1]);
            } else {
                updateMaps(input);
            }
            input = scanner.nextLine();
        }
        System.out.println("Children:");
        children.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
        System.out.println("Presents:");
        presents.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void updateMaps(String input) {
        String[] data = input.split("->");
        String childName = data[0];
        String presentType = data[1];
        int numPresents = Integer.parseInt(data[2]);

        if (children.containsKey(data[0])) {
            children.put(childName, children.get(childName) + numPresents);
        }
        children.putIfAbsent(childName,numPresents);

        if (presents.containsKey(presentType)) {
            presents.put(presentType, presents.get(presentType) + numPresents);
        }
        presents.putIfAbsent(presentType, numPresents);
    }
}
