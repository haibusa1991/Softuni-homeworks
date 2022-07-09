package drawingWithCycles;

import java.util.Scanner;

public class ME07ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < n; j++) {

            if (j == 0) {
                for (int k = 0; k < n + 1; k++) {
                    System.out.print(" ");
                }
                System.out.print("|\n");
            }

            for (int k = 0; k < n - j - 1; k++) {
                System.out.print(" ");
            }

            for (int k = 0; k < j + 1; k++) {
                System.out.print("*");
            }

            System.out.print(" | ");

            for (int k = 0; k < j + 1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }
}
