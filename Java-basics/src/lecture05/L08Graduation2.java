package lecture05;

import java.util.Scanner;

public class L08Graduation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        boolean hasFailedOnce = false;
        boolean hasFailed = false;
        int grade = 0;
        double totalGrade = 0;

        while (grade < 12) {
            double currentGrade = Double.parseDouble(scanner.nextLine());

            if (currentGrade < 4 && hasFailedOnce) {
                System.out.printf("%s has been excluded at %d grade", name, grade);
                hasFailed = true;
                break;
            }

            if (currentGrade < 4) {
                hasFailedOnce = true;
            }
            grade++;
            totalGrade += currentGrade;

        }
        if (!hasFailed) {
            System.out.printf("%s graduated. Average grade: %.2f", name, totalGrade / 12);
        }

    }
}
