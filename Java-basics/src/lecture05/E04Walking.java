package lecture05;

import java.util.Scanner;

public class E04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = 0;
        final int TARGET_STEPS = 10000;

        while (steps < TARGET_STEPS) {

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("going home")) {
                steps += Integer.parseInt(scanner.nextLine());
                break;
            }
            steps += Integer.parseInt(input);
        }

        if (steps < TARGET_STEPS) {
            System.out.printf("%d more steps to reach goal.", TARGET_STEPS - steps);
        } else {
            System.out.printf("Goal reached! Good job!\n%d steps over the goal!", steps - TARGET_STEPS);
        }
    }
}
