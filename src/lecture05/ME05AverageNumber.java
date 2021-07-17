package lecture05;

import java.util.Scanner;

public class ME05AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            sum += value;
        }
        System.out.printf("%.2f", 1.0 * sum / n);
    }
}
