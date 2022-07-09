package lecture04;

import java.util.Scanner;

public class E08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = Integer.parseInt(scanner.nextLine());
        long num2 = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", 1.0 * factorial(num1) / factorial(num2));

    }

    public static long factorial(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
