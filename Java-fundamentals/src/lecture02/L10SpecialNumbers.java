package lecture02;

import java.util.Scanner;

public class L10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " -> " + isSpecial(i));
        }
    }

    public static String isSpecial(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        if (sum == 5 || sum == 7 || sum == 11) return "True";
        return "False";
    }
}
