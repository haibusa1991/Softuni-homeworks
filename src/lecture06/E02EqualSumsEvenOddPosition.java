package lecture06;

import java.util.Scanner;

public class E02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = Integer.parseInt(scanner.nextLine());
        int upperBound = Integer.parseInt(scanner.nextLine());

        for (int i = lowerBound; i <= upperBound; i++) {
            String k = "" + i;
            int evenSum = 0;
            int oddSum = 0;

            for (int j = 0; j < k.length(); j++) {
                int a = Integer.parseInt("" + k.charAt(j));
                if (j % 2 == 0) {
                    evenSum += a;
                } else {
                    oddSum += a;
                }
            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }

    }
}
