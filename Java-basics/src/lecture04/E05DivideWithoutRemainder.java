package lecture04;

import java.util.Scanner;

public class E05DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());

            if (value % 2 == 0) {
                p1++;
            }
            if (value % 3 == 0) {
                p2++;
            }
            if (value % 4 == 0) {
                p3++;
            }

        }

        System.out.printf("%.2f%%\n", 1.0 * p1 / numNumbers * 100);
        System.out.printf("%.2f%%\n", 1.0 * p2 / numNumbers * 100);
        System.out.printf("%.2f%%", 1.0 * p3 / numNumbers * 100);
    }
}
