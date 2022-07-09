package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/1773#1

import java.util.*;
import java.util.stream.Collectors;

public class M17TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] data = input.split(" ");

            switch (data[0]) {
                case "Loot":
                    for (int i = 1; i < data.length; i++) {
                        if (!chest.contains(data[i])) {
                            chest.add(0, data[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < chest.size()) {
                        chest.add(chest.get(index));
                        chest.remove(index);
                    }
                    break;
                case "Steal":
                    int numStolenItems = Integer.parseInt(data[1]);
                    List<String> stolenItems = new ArrayList<>();
                    for (int i = 0; i < numStolenItems; i++) {
                        if (chest.isEmpty()) {
                            break;
                        }
                        stolenItems.add(chest.get(chest.size() - 1));
                        chest.remove(chest.size() - 1);
                    }
                    Collections.reverse(stolenItems);
                    System.out.println(stolenItems.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }
            input = scanner.nextLine();
        }
        int totalCredits = 0;

        for (String currentItem : chest) {
            totalCredits += currentItem.length();
        }

        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageCredits = 1.0 * totalCredits / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageCredits);
        }
    }
}
