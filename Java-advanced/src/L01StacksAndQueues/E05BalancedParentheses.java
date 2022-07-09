package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> parentheses = new ArrayDeque<>();
        for (Character currentChar : input.toCharArray()) {
            if ((currentChar == '}'
                    || currentChar == ']'
                    || currentChar == ')') && parentheses.isEmpty()) {
                System.out.println("NO");
                return;
            }
            if (currentChar == '{'
                    || currentChar == '['
                    || currentChar == '(') {
                parentheses.push(currentChar);
            }
            if (currentChar == '}' && parentheses.peek() == '{') {
                parentheses.pop();
            } else if (currentChar == ']' && parentheses.peek() == '[') {
                parentheses.pop();
            } else if (currentChar == ')' && parentheses.peek() == '(') {
                parentheses.pop();
            }
        }
        if (parentheses.isEmpty()) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
