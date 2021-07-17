package lecture06;

import java.util.Scanner;

public class E01NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int currentNumber = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (currentNumber > n) {
                    break;
                }
                System.out.printf("%d ", currentNumber);
                currentNumber++;
            }
            System.out.print("\n");
        }

    }
}
