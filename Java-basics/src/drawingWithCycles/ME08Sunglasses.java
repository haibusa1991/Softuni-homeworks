package drawingWithCycles;

import java.util.Scanner;

public class ME08Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int middleRow;

        if (n % 2 == 0) {
            middleRow = n / 2-1;
        } else {
            middleRow = n / 2;
        }


        for (int i = 0; i < n; i++) {

            if (i == 0 || i == n - 1) {
                for (int j = 0; j < 2 * n; j++) {
                    System.out.print("*");
                }

                for (int j = 0; j < n; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 2 * n; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }


            if (i == middleRow) {
                System.out.print("*");
                for (int j = 0; j < 2 * n - 2; j++) {
                    System.out.print("/");
                }
                System.out.print("*");
                for (int j = 0; j < n; j++) {
                    System.out.print("|");
                }

                System.out.print("*");
                for (int j = 0; j < 2 * n - 2; j++) {
                    System.out.print("/");
                }
                System.out.print("*\n");

            }

            if (i!=0 && i!=n-1 && i!=middleRow){
                System.out.print("*");
                for (int j = 0; j < 2 * n - 2; j++) {
                    System.out.print("/");
                }
                System.out.print("*");
                for (int j = 0; j < n; j++) {
                    System.out.print(" ");
                }

                System.out.print("*");
                for (int j = 0; j < 2 * n - 2; j++) {
                    System.out.print("/");
                }
                System.out.print("*\n");
            }
        }
    }
}
