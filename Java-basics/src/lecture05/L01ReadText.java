package lecture05;

import java.util.Scanner;

public class L01ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Stop")) {

            System.out.println(input);
            input = scanner.nextLine();
        }
    }
}
