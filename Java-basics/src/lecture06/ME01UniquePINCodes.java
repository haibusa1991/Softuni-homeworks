package lecture06;

import java.util.Scanner;

public class ME01UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= n1; i++) {
            if (i % 2 != 0) {
                continue;
            }
            for (int j = 2; j <= n2; j++) {
                if (j == 4 || j == 6 || j > 7) {
                    continue;
                }
                for (int k = 2; k <= n3; k++) {
                    if (k % 2 != 0) {
                        continue;
                    }
//                    System.out.print("" + i + j + k + "\n");
                    System.out.printf("%d %d %d\n", i, j, k);
                }
            }

        }
    }
}
