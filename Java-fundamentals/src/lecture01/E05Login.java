package lecture01;

import java.util.Scanner;

public class E05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        String password = "";

        for (int i = user.length() - 1; i >= 0; i--) {
            password += user.charAt(i);
        }

        int wrongPasswords = 0;
        String enteredPassword = scanner.nextLine();
        while (!enteredPassword.equals(password)) {
            wrongPasswords++;
            if (wrongPasswords > 3) {
                System.out.printf("User %s blocked!", user);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", user);
    }
}
