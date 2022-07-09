package lecture04;

import java.util.Scanner;

public class E10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < n; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isTopNumber(int n) {
        return isSumDivisibleBy8(n) && hasOddDigit(n);

    }

    public static boolean isSumDivisibleBy8(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 8 == 0;
    }

    public static boolean hasOddDigit(int n) {
        while (n != 0) {
            if ((n % 10) % 2 != 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
