package lecture01;

import java.util.Scanner;

public class E06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());
        int value = inputNumber;

        int sum = 0;
        while (value > 0) {
            int currentDigit = value % 10;
            int currentFactorial = 1;
            for (int i = 1; i <= currentDigit; i++) {
                currentFactorial *= i;
            }
            sum += currentFactorial;
            value /= 10;
        }
        if (sum == inputNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
