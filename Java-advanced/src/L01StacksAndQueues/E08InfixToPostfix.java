package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> operators = new ArrayDeque<>();
        for (String token : input) {
            if (!isOperator(token) && !isParenthesis(token)) {
                System.out.print(token + " ");
            } else if (isOperator(token)) {
                if ((!operators.isEmpty() && orderOf(operators.peek()) < orderOf(token))
                        || (!operators.isEmpty() && orderOf(operators.peek()) == orderOf(token))) {
                    while (!operators.isEmpty()) {
                        System.out.print(operators.pop() + " ");
                        if (!operators.isEmpty() && orderOf(operators.peek()) > orderOf(token)) {
                            break;
                        }
                    }
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    System.out.print(operators.pop() + " ");
                }
                if (!operators.isEmpty()) {
                    operators.pop();
                }
            }
        }
        while (!operators.isEmpty()) {
            String currentOperator = operators.pop();
            System.out.print(currentOperator + " ");
        }
    }

    private static boolean isOperator(String s) {
        return s.length() == 1 && (s.charAt(0) == '+'
                || s.charAt(0) == '-'
                || s.charAt(0) == '*'
                || s.charAt(0) == '/');
    }

    private static boolean isParenthesis(String s) {
        return s.length() == 1 && (s.charAt(0) == '(' || s.charAt(0) == ')');
    }

    //level 1 -> * and /
    //level 2 -> + and -
    //level 3 -> ( and )
    private static int orderOf(String s) {
        if (s.charAt(0) == '*' || s.charAt(0) == '/') {
            return 1;
        } else if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return 2;
        }
        return 3;
    }
}
