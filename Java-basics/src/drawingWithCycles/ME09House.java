package drawingWithCycles;

import java.util.Scanner;

public class ME09House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean isEven = n % 2 == 0;

        for (int i = 1; i <= (n + 1) / 2; i++) {

            if (isEven) {

                for (int j = 0; j < (n / 2) - i; j++) {
                    System.out.print("-");
                }

                for (int j = 0; j < i * 2; j++) {
                    System.out.print("*");

                }

                for (int j = 0; j < (n / 2) - i; j++) {
                    System.out.print("-");
                }
                System.out.print("\n");

            } else {

                for (int j = (n / 2) - i + 1; j > 0; j--) {
                    System.out.print("-");
                }

                for (int j = 0; j < i - 1; j++) {
                    System.out.print("*");
                }
                System.out.print("*");

                for (int j = 0; j < i - 1; j++) {
                    System.out.print("*");
                }

                for (int j = (n / 2) - i + 1; j > 0; j--) {
                    System.out.print("-");
                }
                System.out.print("\n");
            }
        }
        for (int j = 0; j < (n / 2); j++) {
            System.out.print("|");
            for (int k = 0; k < n - 2; k++) {
                System.out.print("*");
            }
            System.out.print("|\n");


        }
    }
}


