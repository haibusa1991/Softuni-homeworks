package lecture06;

import java.util.Scanner;

public class ME13PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pair1Start = Integer.parseInt(scanner.nextLine());
        int pair2Start = Integer.parseInt(scanner.nextLine());
        int pair1End = Integer.parseInt(scanner.nextLine());
        int pair2End = Integer.parseInt(scanner.nextLine());

        pair1End += pair1Start;
        pair2End += pair2Start;

        for (int i = pair1Start; i <= pair1End; i++) {
            for (int j = pair2Start; j <= pair2End; j++) {
                boolean isPair1Prime = true;
                boolean isPair2Prime = true;

                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        isPair1Prime = false;
                        break;
                    }
                }

                for (int l = 2; l < j; l++) {
                    if (j % l == 0) {
                        isPair2Prime = false;
                        break;
                    }
                }

                if (isPair1Prime && isPair2Prime) {
                    System.out.printf("%d%d\n", i, j);
                }
            }
        }
    }
}

