package lecture08;

import java.util.Scanner;

public class E05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = trimLeadingZeroes(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder(num1.length() + 1);
        int buffer = 0;
        for (int i = num1.length() - 1; i > -1; i--) {
            if (num1.equals("0") || num2 == 0) {
                result.append(0);
                break;
            }
            int currentDigit = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int currentResult = currentDigit * num2 + buffer;
            buffer = 0;
            if (currentResult > 9) {
                String currentResultString = "" + currentResult;
                String lastDigit = "" + currentResultString.charAt(1);
                buffer = Integer.parseInt(String.valueOf(currentResultString.charAt(0)));
                result.insert(0, lastDigit);
            } else {
                result.insert(0, currentResult);
            }
            if (i == 0 && buffer > 0) {
                result.insert(0, buffer);
            }
        }
        System.out.println(result);
    }

    private static String trimLeadingZeroes(String input) {
        StringBuilder output = new StringBuilder(input);
        while (output.length() >= 1 && output.charAt(0) == '0') {
            output.deleteCharAt(0);
        }
        if (output.length() == 0) {
            return "0";
        }
        return output.toString();
    }
}
