package lecture04;

import java.util.Scanner;

public class E09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += "" + s.charAt(i);
        }
        return s.equals(reverse);
    }
}
