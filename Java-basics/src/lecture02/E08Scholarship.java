package lecture02;

import java.util.Scanner;

public class E08Scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double income = Double.parseDouble(sc.nextLine());
        double averageGrade = Double.parseDouble(sc.nextLine());
        double minimumIncome = Double.parseDouble(sc.nextLine());

        double scholarshipExcellence = 0;
        double scholarshipSocial = 0;

        if (averageGrade >= 5.5) {
            scholarshipExcellence = averageGrade * 25;
        }

        if (averageGrade >= 4.5) {
            if (minimumIncome > income) {
                scholarshipSocial = minimumIncome * .35;
            }

        }
        if (scholarshipSocial + scholarshipExcellence == 0) {
            System.out.println("You cannot get a scholarship!");
        } else if (scholarshipExcellence >= scholarshipSocial) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(scholarshipExcellence));
        } else if (scholarshipSocial > scholarshipExcellence) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(scholarshipSocial));
        }
    }
}
