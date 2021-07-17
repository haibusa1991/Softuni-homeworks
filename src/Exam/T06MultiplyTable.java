package Exam;

import java.util.Scanner;

public class T06MultiplyTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num % 10; i++) {
            for (int j = 1; j <= (num / 10) % 10; j++) {
                for (int k = 1; k <= num / 100; k++) {
                    System.out.printf("%d * %d * %d = %d;\n", i, j, k, i * j * k);
                }
            }
        }
    }
}
