package lecture02;

import java.util.Scanner;

public class E06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.printf("%c%c%c%n", (char) i + 97, (char) j + 97, (char) k + 97);

                }

            }

        }
    }
}
