package lecture06;

import java.util.Scanner;

public class ME03LuckyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if ((i + j == k + l) && n % (i + j) == 0) {
                            System.out.print("" + i + j + k + l + " ");
                        }
                    }
                }

            }

        }
    }
}
