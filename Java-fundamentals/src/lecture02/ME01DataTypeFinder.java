package lecture02;

import java.util.Scanner;

public class ME01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            boolean isInteger = false;
            boolean isDouble = false;
            boolean isChar = false;
            boolean isBoolean = false;

            try {
                int value = Integer.parseInt(input);
                isInteger = true;
            } catch (Exception ignored) {
            }

            try {
                if (!isInteger) {
                    double value = Double.parseDouble(input);
                    isDouble = true;
                }
            } catch (Exception ignored) {
            }

            if (input.length() == 1) {
                if (!Character.isDigit(input.charAt(0))) {
                    isChar = true;
                }
            }

            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                isBoolean = true;
            }

            if (isInteger) {
                System.out.println(input + " is integer type");
            } else if (isDouble) {
                System.out.println(input + " is floating point type");
            } else if (isChar) {
                System.out.println(input + " is character type");
            } else if (isBoolean) {
                System.out.println(input + " is boolean type");
            } else {
                System.out.println(input + " is string type");
            }

            input = scanner.nextLine();
        }
    }
}
