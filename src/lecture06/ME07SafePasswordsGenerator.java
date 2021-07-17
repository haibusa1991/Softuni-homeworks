package lecture06;

import java.util.Scanner;

public class ME07SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxPasswords = Integer.parseInt(scanner.nextLine());

        char A = 35;
        char B = 64;
        int generatedPasswords = 0;

        for (int x = 1; x <= a; x++) {
            for (int y = 1; y <= b; y++) {
                generatedPasswords++;

                if (generatedPasswords > maxPasswords) {
                    break;
                }

                System.out.print("" + A + B + x + y + B + A + "|");

                A++;
                if (A > 55) {
                    A = 35;
                }

                B++;
                if (B > 96) {
                    B = 64;
                }

            }

        }
    }
}
