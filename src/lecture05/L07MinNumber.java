package lecture05;

import java.util.Scanner;

public class L07MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        int minNumber = Integer.MAX_VALUE;

        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            if (Integer.parseInt(input) < minNumber) {
                minNumber = Integer.parseInt(input);
            }
        }
        System.out.println(minNumber);
    }
}
