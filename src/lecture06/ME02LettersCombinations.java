package lecture06;

import java.util.Scanner;

public class ME02LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char n1 = scanner.nextLine().charAt(0);
        char n2 = scanner.nextLine().charAt(0);
        char n3 = scanner.nextLine().charAt(0);

        int validCombinations = 0;
        for (int i = n1; i <= n2; i++) {
            if (i == n3) continue;
            for (int j = n1; j <= n2; j++) {
                if (j == n3) continue;
                for (int k = n1; k <= n2; k++) {
                    if (k == n3) continue;
                    System.out.print("" + (char) i + (char) j + (char) k + " ");

                    validCombinations++;
                }

            }

        }
        System.out.print(validCombinations);
    }
}
