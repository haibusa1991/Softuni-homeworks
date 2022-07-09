package lecture06;

import java.util.Scanner;

public class ME12TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = Integer.parseInt(scanner.nextLine());

        int password = 0;
        int printedPasswords = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if (i * j + k * l == M) {
                            if (i < j && k > l) {
                                System.out.print("" + i + j + k + l + " ");
                                printedPasswords++;
                                if (printedPasswords==4) {
                                    password = Integer.parseInt("" + i + j + k + l);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (password != 0) {
            System.out.printf("\nPassword: %d", password);
        } else {
            System.out.print("\nNo!");
        }
    }

}
