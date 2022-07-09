package lecture04;

import java.util.Scanner;

public class ME05GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTurns = Integer.parseInt(scanner.nextLine());

        double result = 0;

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;

        for (int i = 0; i < numTurns; i++) {
            int value = Integer.parseInt(scanner.nextLine());

            if (value < 0 || value > 50) {
                result /= 2;
                p6++;
            } else if (value <= 9) {
                result += value * 0.2;
                p1++;
            } else if (value <= 19) {
                result += value * 0.3;
                p2++;
            } else if (value <= 29) {
                result += value * 0.4;
                p3++;
            } else if (value <= 39) {
                result += 50;
                p4++;
            } else {
                result += 100;
                p5++;
            }
        }
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", 1.0 * p1 / numTurns * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", 1.0 * p2 / numTurns * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", 1.0 * p3 / numTurns * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", 1.0 * p4 / numTurns * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", 1.0 * p5 / numTurns * 100);
        System.out.printf("Invalid numbers: %.2f%%", 1.0 * p6 / numTurns * 100);
    }
}
