package lecture06;

import java.util.Scanner;

public class E05PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 97; k < l + 97; k++) {
                   for (int m = 97; m < l + 97; m++) {
                       int t = Math.max(i, j);
                       for (int o = t+1; o < n+1; o++) {
                           System.out.print("" + i + j + (char) k + (char) m + o + " ");
                       }

                    }

                }

            }

        }
    }
}
