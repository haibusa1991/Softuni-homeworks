package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentUrl = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    currentUrl = history.pop();
                    System.out.println(currentUrl);
                }
            } else {
                if (!currentUrl.equals("")) {
                    history.push(currentUrl);
                }
                currentUrl = input;
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
