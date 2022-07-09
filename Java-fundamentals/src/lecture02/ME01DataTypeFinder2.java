package lecture02;

import java.util.Scanner;

public class ME01DataTypeFinder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            Scanner scanner1 = new Scanner(input);
            if (scanner1.hasNextInt()) {
                System.out.println(input + " is integer type");
            } else if (scanner1.hasNextDouble()) {
                System.out.println(input + " is floating point type");
            } else if (scanner1.nextLine().length() == 1) {
                System.out.println(input + " is character type");
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.println(input + " is boolean type");
            } else {
                System.out.println(input + " is string type");
            }
            input = scanner.nextLine();
        }
    }
}
