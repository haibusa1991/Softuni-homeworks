package lecture04;

import java.util.Scanner;

public class E06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(getMiddleCharacters(input));
    }

    private static String getMiddleCharacters(String s) {
        if (s.length() % 2 == 0) {
            return "" + s.charAt((s.length() / 2) - 1) + s.charAt(s.length() / 2);
        } else {
            return "" + s.charAt(s.length() / 2);
        }

    }
}
