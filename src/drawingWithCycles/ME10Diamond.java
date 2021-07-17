package drawingWithCycles;

import java.util.Scanner;

public class ME10Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n % 2 != 0) {
            //upper part of odd diamond
            for (int i = 0; i < (n / 2) + 1; i++) {

                for (int j = 0; j < (n / 2) - i; j++) {
                    System.out.print("-");
                }

                System.out.print("*");

                for (int j = 0; j < i; j++) {
                    System.out.print("-");
                }

                for (int j = 0; j < i - 1; j++) {
                    System.out.print("-");
                }

                if (i != 0) {
                    System.out.print("*");
                }

                for (int j = 0; j < (n / 2) - i; j++) {
                    System.out.print("-");
                }
                System.out.print("\n");
            }
            //lower part of odd diamond
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("-");
                }

                System.out.print("*");

                for (int j = 0; j < (n / 2) - 1 - i; j++) {
                    System.out.print("-");
                }

                for (int j = 0; j < (n / 2) - 2 - i; j++) {
                    System.out.print("-");
                }

                if (i != (n / 2) - 1) {
                    System.out.print("*");
                }

                for (int j = 0; j < i + 1; j++) {
                    System.out.print("-");
                }
                System.out.print("\n");
            }
        } else {
            //upper part of even diamond
            for (int i = 0; i < (n / 2); i++) {

                for (int j = 0; j < (n / 2) - 1 - i; j++) {
                    System.out.print("-");
                }
                System.out.print("*");

                for (int j = 0; j < i; j++) {
                    System.out.print("--");
                }

                System.out.print("*");

                for (int j = 0; j < n / 2 - 1 - i; j++) {
                    System.out.print("-");
                }
                System.out.print("\n");
            }

            //lower part of even diamond
            for (int i = 0; i < (n / 2) - 1; i++) {
                for (int j = 0; j < i+1; j++) {
                    System.out.print("-");
                }

                System.out.print("*");

                for (int j = 0; j < (n/2)-2-i; j++) {
                    System.out.print("--");
                }

                    System.out.print("*");

                for (int j = 0; j < i+1; j++) {
                    System.out.print("-");
                }

                System.out.print("\n");
            }
        }
    }
}
