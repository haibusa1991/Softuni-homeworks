package midExamExercise;
//https://judge.softuni.bg/Contests/Practice/Index/2305#0

import java.util.Scanner;


public class M10CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = Integer.parseInt(scanner.nextLine());
        int numWonBattles = 0;
        String input = scanner.nextLine();
        boolean hasDepletedHealth = false;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance > health) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", numWonBattles, health);
                hasDepletedHealth = true;
                break;
            }
            health -= distance;
            numWonBattles++;
            if (numWonBattles % 3 == 0) {
                health += numWonBattles;
            }
            input = scanner.nextLine();
        }

        if (!hasDepletedHealth) {
            System.out.printf("Won battles: %d. Energy left: %d", numWonBattles, health);
        }
    }

}
