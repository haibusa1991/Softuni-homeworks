package lecture04;

import java.util.Scanner;

public class ME04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        double totalScore = 0;
        for (int i = 0; i < numStudents; i++) {

            double currentGrade = Double.parseDouble(scanner.nextLine());
            totalScore+=currentGrade;

            if (currentGrade >= 5) {
                p1++;
            } else if (currentGrade >= 4) {
                p2++;
            } else if (currentGrade >= 3) {
                p3++;
            } else {
                p4++;
            }

        }
        System.out.printf("Top students: %.2f%%\n",1.0*p1/numStudents*100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n",1.0*p2/numStudents*100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n",1.0*p3/numStudents*100);
        System.out.printf("Fail: %.2f%%\n",1.0*p4/numStudents*100);
        System.out.printf("Average: %.2f",totalScore/numStudents);
    }
}
