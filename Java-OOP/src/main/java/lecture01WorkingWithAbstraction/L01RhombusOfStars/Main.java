package lecture01WorkingWithAbstraction.L01RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printTop(n);
        printBottom(n);

    }

    private static void printRow(int numStars, int totalStars) {
        for (int i = 0; i < totalStars - numStars; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < numStars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTop(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            printRow(i, numRows);
        }
    }

    private static void printBottom(int numRows) {
        for (int i = numRows - 1; i > 0; i--) {
            printRow(i, numRows);
        }
    }
}
