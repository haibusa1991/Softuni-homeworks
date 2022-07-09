package lecture06Solid.logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Controller controller = new Controller(n);
        for (int i = 0; i < n; i++) {
            controller.createAppender(scanner.nextLine());
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            controller.logMessage(input);
            input = scanner.nextLine();
        }

        System.out.println(controller.getAppendersInfo());
    }
}
