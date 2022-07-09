package lecture08;

import java.util.Scanner;

public class L05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                digits.append(currentChar);
            } else if (Character.isAlphabetic(currentChar)) {
                letters.append(currentChar);
            } else {
                others.append(currentChar);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}