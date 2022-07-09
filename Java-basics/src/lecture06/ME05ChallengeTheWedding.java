package lecture06;

import java.util.Scanner;

public class ME05ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int numTables = Integer.parseInt(scanner.nextLine());

        int occupiedTables = 0;
        boolean hasFinished = false;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                System.out.print("(" + i + " <-> " + j + ") ");
                occupiedTables++;
                if (occupiedTables == numTables) {
                    hasFinished = true;
                    break;
                }
            }
            if (hasFinished) {
                break;
            }

        }
    }
}
