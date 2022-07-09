package lecture08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Double> results = new ArrayList<>();
        for (String string : input) {
            results.add(calculateNumber(string));
        }
        double result = results.stream().mapToDouble(e -> e).sum();
        System.out.printf("%.2f", result);
    }

    private static double calculateNumber(String input) {
        double currentNumber = Double.parseDouble(new StringBuilder(input).deleteCharAt(0).deleteCharAt(input.length() - 2).toString());
        if (Character.isUpperCase(input.charAt(0))) {
            currentNumber /= getAlphabetPosition(input.charAt(0));
        } else {
            currentNumber *= getAlphabetPosition(input.charAt(0));
        }

        char secondLetter = input.charAt(input.length() - 1);
        if (Character.isUpperCase(secondLetter)) {
            currentNumber -= getAlphabetPosition(secondLetter);
        } else {
            currentNumber += getAlphabetPosition(secondLetter);
        }
        return currentNumber;
    }

    private static int getAlphabetPosition(char letter) {
        if (Character.isUpperCase(letter)) {
            return letter - 64;
        } else {
            return letter - 96;
        }
    }
}
