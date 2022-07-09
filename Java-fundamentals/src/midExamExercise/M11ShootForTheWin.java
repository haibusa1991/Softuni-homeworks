package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2305#1

import java.util.Arrays;
import java.util.Scanner;

public class M11ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int targetIndex = Integer.parseInt(input);
            if (targetIndex >= 0 && targetIndex < targets.length && targets[targetIndex] != -1) {
                int targetValue = targets[targetIndex];
                targets[targetIndex] = -1;
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] == -1) {
                        continue;
                    }
                    if (targets[i] > targetValue) {
                        targets[i] -= targetValue;
                    } else {
                        targets[i] += targetValue;
                    }
                }
            }
            input = scanner.nextLine();
        }
        int shotTargets = 0;
        for (int target : targets) {
            if (target == -1) {
                shotTargets++;
            }
        }
        System.out.printf("Shot targets: %d -> ", shotTargets);
        System.out.print(Arrays.toString(targets).replaceAll("[\\[\\],]", ""));
    }
}

