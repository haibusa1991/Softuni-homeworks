package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L08BrowserHistoryUpgrade {
    private static ArrayDeque<String> backHistory = new ArrayDeque<>();
    private static ArrayDeque<String> forwardHistory = new ArrayDeque<>();
    private static String currentUrl = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            switch (input) {
                case "forward":
                    goForward();
                    break;
                case "back":
                    goBack();
                    break;
                default:
                    newUrl(input);
            }
            input = scanner.nextLine();
        }
    }

    private static void newUrl(String input) {
        if (!currentUrl.equals("")) {
            backHistory.push(currentUrl);
        }
        currentUrl = input;
        System.out.println(currentUrl);
        forwardHistory.clear();
    }

    private static void goBack() {
        if (backHistory.isEmpty()) {
            System.out.println("no previous URLs");
        } else {
            forwardHistory.push(currentUrl);
            currentUrl = backHistory.pop();
            System.out.println(currentUrl);
        }
    }

    private static void goForward() {
        if (forwardHistory.isEmpty()) {
            System.out.println("no next URLs");
        } else {
            backHistory.push(currentUrl);
            currentUrl = forwardHistory.pop();
            System.out.println(currentUrl);
        }
    }
}


