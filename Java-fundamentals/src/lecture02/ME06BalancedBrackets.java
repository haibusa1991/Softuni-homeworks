package lecture02;

import java.util.Scanner;

public class ME06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        boolean isUnbalanced = false;
        char lastBracket = ' ';
        int closingBrackets = 0;
        int openingBrackets = 0;

        for (int i = 0; i < numLines; i++) {
            char currentInput = scanner.nextLine().charAt(0);

            if (currentInput == '(') {
                openingBrackets++;
                if (lastBracket == currentInput) {
                    isUnbalanced = true;
                }
                lastBracket = currentInput;
            }

            if (currentInput == ')') {
                closingBrackets++;
                if (lastBracket == currentInput) {
                    isUnbalanced = true;
                }
                lastBracket = currentInput;
            }
        }
        if (closingBrackets != openingBrackets) {
            isUnbalanced = true;
        }
        if (isUnbalanced) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}
