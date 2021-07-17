package lecture03;

import java.util.Scanner;

public class E06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.next();

        switch (operator) {
            case "+":
            case "-":
            case "*":
                int result = N1 + N2;
                if (operator.equals("-")) {
                    result = N1 - N2;
                } else if (operator.equals("*")) {
                    result = N1 * N2;
                }

                String resultIsEvenOrOdd;

                if (result % 2 == 0) {
                    resultIsEvenOrOdd = "even";
                } else {
                    resultIsEvenOrOdd = "odd";
                }
                System.out.printf("%d %s %d = %d - %s", N1, operator, N2, result, resultIsEvenOrOdd);
                break;

            case "/":
                if (N2 == 0) {
                    System.out.printf("Cannot divide %d by zero", N1);
                } else {
                    System.out.printf("%d / %d = %.2f", N1, N2, 1.0*N1 / N2);
                }
                break;

            case "%":
                if (N2 == 0) {
                    System.out.printf("Cannot divide %d by zero", N1);
                } else {
                    System.out.printf("%d %% %d = %d", N1, N2, N1 % N2);
                }
                break;
        }

    }
}
