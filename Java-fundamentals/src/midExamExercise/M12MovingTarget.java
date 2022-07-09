package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2305#2

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M12MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String command = data[0];
            int index = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            switch (command) {
                case "Shoot":
                    if (index >= 0 && index < targets.size()) {
                        int targetHealth = targets.get(index) - power;
                        if (targetHealth <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, targetHealth);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, power);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index - power >= 0 && index + power < targets.size()) {
                        int targetIndex = index - power;
                        for (int i = 0; i < 2 * power + 1; i++) {
                            targets.remove(targetIndex);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(targets.toString()
                .replaceAll("[\\[\\],]", "")
                .replaceAll(" ", "|"));
    }
}
