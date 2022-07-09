package lecture05;

import java.util.Scanner;

public class E02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numAllowedBadGrades = Integer.parseInt(scanner.nextLine());
        int totalBadGrades = 0;
        int totalScore = 0;
        int numProblemsSolved = 0;
        String lastProblemName = "";

        while (true) {
            String currentProblemName = scanner.nextLine();

            if (currentProblemName.equalsIgnoreCase("enough")) {
                System.out.printf(
                        "Average score: %.2f\n" +
                        "Number of problems: %d\n" +
                        "Last problem: %s",

                        1.0 * totalScore / numProblemsSolved,
                        numProblemsSolved,
                        lastProblemName);
                break;
            }
            int currentGrade = Integer.parseInt(scanner.nextLine());

            lastProblemName = currentProblemName;
            totalScore += currentGrade;
            numProblemsSolved++;

            if (currentGrade <= 4) {
                totalBadGrades++;
            }

            if (totalBadGrades == numAllowedBadGrades) {
                System.out.printf("You need a break, %d poor grades.", totalBadGrades);
                break;
            }
        }
    }
}
