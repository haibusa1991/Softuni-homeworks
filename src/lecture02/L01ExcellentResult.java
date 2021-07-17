package lecture02;

import java.util.Scanner;

public class L01ExcellentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int grade = Integer.parseInt(sc.nextLine());
        if (grade >= 5) {
            System.out.println("Excellent!");
        }

    }
}
