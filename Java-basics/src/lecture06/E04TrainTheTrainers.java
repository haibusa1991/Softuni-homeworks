package lecture06;

import java.util.Scanner;

public class E04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numJury = Integer.parseInt(scanner.nextLine());
        String presentationName = scanner.nextLine();

        int numPresentations = 0;
        double finalScores = 0;

        while (!presentationName.equalsIgnoreCase("Finish")) {

            double totalScore = 0;
            for (int i = 0; i < numJury; i++) {
                totalScore += Double.parseDouble(scanner.nextLine());
            }
            numPresentations++;
            finalScores += totalScore / numJury;
            System.out.printf("%s - %.2f.\n", presentationName, totalScore / numJury);
            presentationName = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", finalScores / numPresentations);
    }
}
