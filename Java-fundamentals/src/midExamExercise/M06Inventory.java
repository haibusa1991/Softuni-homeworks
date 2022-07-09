package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2028#2
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M06Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] command = input.split(" - ");
            switch (command[0]) {
                case "Collect":
                    if (!inventory.contains(command[1])) {
                        inventory.add(command[1]);
                    }
                    break;
                case "Drop":
                    inventory.remove(command[1]);
                    break;
                case "Combine Items":
                    String oldItem = command[1].split(":")[0];
                    String newItem = command[1].split(":")[1];
                    if (inventory.contains(oldItem)) {
                        inventory.add(inventory.indexOf(oldItem)+1, newItem);
                    }
                    break;
                case "Renew":
                    if (inventory.contains(command[1])) {
                        inventory.remove(command[1]);
                        inventory.add(command[1]);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(inventory.toString().replaceAll("[\\[\\]]", ""));
    }
}
