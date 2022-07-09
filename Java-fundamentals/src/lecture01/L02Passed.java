package lecture01;

import java.util.Scanner;

public class L02Passed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        if (grade >= 3) {
            System.out.println("Passed!");
        }
    }
}
