package lecture04;

import java.util.Scanner;

public class L11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double n2 = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", calculate(n1, n2, operator));
    }

    private static double calculate(double n1, double n2, String operator) {

        switch (operator) {
            case "*":
                return n1 * n2;
            case "+":
                return n1 + n2;
            case "/":
                return n1 / n2;
            case "-":
                return n1 - n2;
        }
        return 0;
    }
}
