package lecture04;

import java.util.Scanner;

public class L10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(getEvenSum(input) * getOddSum(input));
    }

    private static int getEvenSum(String s) {
        int sum = 0;
        int num = Math.abs(Integer.parseInt(s));
        while (num > 0) {
            if ((num % 10) % 2 == 0) {
                sum += num % 10;
            }
            num /= 10;
        }
        return sum;
    }

    private static int getOddSum(String s) {
        int sum = 0;
        int num = Math.abs(Integer.parseInt(s));
        while (num > 0) {
            if ((num % 10) % 2 != 0) {
                sum += num % 10;
            }
            num /= 10;
        }
        return sum;
    }
}
