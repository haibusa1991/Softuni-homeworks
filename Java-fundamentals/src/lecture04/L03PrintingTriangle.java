package lecture04;

import java.util.Scanner;

public class L03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());

        printTop(height);
        printBottom(height);
    }

    static void printTop(int input) {
        for (int i = 0; i <= input; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void printBottom(int input) {
        for (int i = input - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}