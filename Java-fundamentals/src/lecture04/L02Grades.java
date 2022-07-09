package lecture04;

import java.util.Scanner;

public class L02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printGradeToWords(grade);
    }

    static void printGradeToWords(double input) {
        if (input < 3) {
            System.out.println("Fail");
        } else if (input < 3.5) {
            System.out.println("Poor");
        } else if (input < 4.5) {
            System.out.println("Good");
        } else if (input < 5.5) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }
    }
}
