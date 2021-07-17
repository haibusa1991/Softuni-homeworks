package lecture06;

import java.util.Scanner;

public class ME08SecretDoorLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hundreds = Integer.parseInt(scanner.nextLine());
        int tens = Integer.parseInt(scanner.nextLine());
        int ones = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= hundreds; i++) {
            if (i % 2 != 0) {
                continue;
            }
            for (int j = 1; j <= tens; j++) {
                if (j == 1 || j == 4 || j == 6 || j == 8 || j == 9) {
                    continue;
                }
                for (int k = 1; k <= ones; k++) {
                    if (k % 2 != 0) {
                        continue;
                    }
                    System.out.println("" + i + " " + j + " " + k);
                }

            }

        }
    }
}
