package lecture02;

import java.util.Scanner;

public class ME05DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numLines = Integer.parseInt(scanner.nextLine());
        String message = "";
        for (int i = 0; i < numLines; i++) {
            char currentChar = scanner.nextLine().charAt(0);
            message += (char) ((int) currentChar + key);
        }
        System.out.println(message);

    }
}
