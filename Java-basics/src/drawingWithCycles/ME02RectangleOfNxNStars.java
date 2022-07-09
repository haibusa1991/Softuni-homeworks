package drawingWithCycles;

import java.util.Scanner;

public class ME02RectangleOfNxNStars {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        int side = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
