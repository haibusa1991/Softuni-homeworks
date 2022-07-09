package Exam;

import java.util.Scanner;

public class T05BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();

        String bestPlayerName = "";
        int maxScoredGoals = 0;
        while (!playerName.equalsIgnoreCase("end")) {
            int numScoredGoals = Integer.parseInt(scanner.nextLine());

            if (numScoredGoals > maxScoredGoals) {
                maxScoredGoals = numScoredGoals;
                bestPlayerName = playerName;
            }

            if (numScoredGoals >= 10) {
                break;
            }
            playerName = scanner.nextLine();
        }
        if (maxScoredGoals >= 3) {
            System.out.printf("%s is the best player!\nHe has scored %d goals and made a hat-trick !!!", bestPlayerName, maxScoredGoals);
        } else {
            System.out.printf("%s is the best player!\nHe has scored %d goals.", bestPlayerName, maxScoredGoals);
        }
    }
}
