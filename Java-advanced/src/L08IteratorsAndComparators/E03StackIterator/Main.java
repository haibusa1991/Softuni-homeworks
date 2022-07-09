package L08IteratorsAndComparators.E03StackIterator;

import L08IteratorsAndComparators.Iterators.Stack;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack stack = new Stack();
        while (!input.equals("END")) {
            String[] tokens = input.replace(",", "").split(" ");
            switch (tokens[0]) {
                case "Push":
                    stack.push(Arrays.stream(tokens)
                            .skip(1)
                            .mapToInt(Integer::parseInt)
                            .toArray());
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
