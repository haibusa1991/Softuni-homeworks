package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stack.push(scanner.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.stream().mapToInt(e -> e).max().orElse(0));
            }
        }
    }
}
