package lecture08;

import java.util.Scanner;

public class E01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");
        for (String username : usernames) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (Character currentChar : username.toCharArray()) {
            if (!Character.isDigit(currentChar)
                    && !Character.isAlphabetic(currentChar)
                    && !currentChar.equals('-')
                    && !currentChar.equals('_')) {
                return false;
            }
        }
        return true;
    }
}
