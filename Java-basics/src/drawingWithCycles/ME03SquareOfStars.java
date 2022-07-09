package drawingWithCycles;

import java.util.Scanner;

public class ME03SquareOfStars {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int stars =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < stars; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}
