package drawingWithCycles;

import java.util.Scanner;

public class ME05SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                System.out.print("+ ");
                for (int j = 0; j < n - 2; j++) {
                    System.out.print("- ");
                }
                System.out.print("+\n");
            }

            if (i > 0 && i != n - 1) {
                System.out.print("| ");
                for (int j = 0; j < n - 2; j++) {
                    System.out.print("- ");
                }
                System.out.print("|\n");
            }

            if (i == n-1) {
                System.out.print("+ ");
                for (int j = 0; j < n - 2; j++) {
                    System.out.print("- ");
                }
                System.out.print("+");
            }


        }
    }
}
