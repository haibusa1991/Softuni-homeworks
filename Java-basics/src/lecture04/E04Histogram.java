package lecture04;

import java.util.Scanner;

public class E04Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());

            if (value < 200) {
                p1++;
            } else if (value < 400) {
                p2++;
            } else if (value < 600) {
                p3++;
            } else if (value < 800) {
                p4++;
            } else {
                p5++;
            }
        }
        System.out.printf("%.2f%%\n", 1.0 * p1 / numNumbers * 100);
        System.out.printf("%.2f%%\n", 1.0 * p2 / numNumbers * 100);
        System.out.printf("%.2f%%\n", 1.0 * p3 / numNumbers * 100);
        System.out.printf("%.2f%%\n", 1.0 * p4 / numNumbers * 100);
        System.out.printf("%.2f%%\n", 1.0 * p5 / numNumbers * 100);

    }
}

