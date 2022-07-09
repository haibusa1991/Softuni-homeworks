package drawingWithCycles;

import java.util.Scanner;

public class ME04TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("$ ");
            }
            System.out.print("\n");
        }
    }
}

