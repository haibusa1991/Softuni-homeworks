package lecture06;

import java.util.Scanner;

public class ME10Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coins1 = Integer.parseInt(scanner.nextLine());
        int coins2 = Integer.parseInt(scanner.nextLine());
        int banknotes5 = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= coins1; i++) {
            for (int j = 0; j <= coins2; j++) {
                for (int k = 0; k <= banknotes5; k++) {
                    if (i + j * 2 + k * 5 == sum) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.\n", i, j, k, sum);
                    }
                }

            }

        }
    }
}
