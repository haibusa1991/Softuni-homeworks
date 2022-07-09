package lecture04;

import java.util.Scanner;

public class E04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (hasValidLength(password)
                & doesContainOnlyLettersAndDigits(password)
                & hasValidCountDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean doesContainOnlyLettersAndDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isValidChar(s.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    private static boolean isValidChar(char c) {
        return (c >= 48 && c <= 57)
                || (c >= 97 && c <= 122)
                || (c >= 65 && c <= 90);
    }


    private static boolean hasValidLength(String s) {
        if (s.length() >= 6 && s.length() <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    private static boolean hasValidCountDigits(String s) {
        int numDigits = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numDigits++;
            }
        }
        if (numDigits >= 2) {
            return true;
        } else {
            System.out.println("Password must have at least 2 digits");
            return false;
        }
    }
}