package lecture06;

import java.util.Scanner;

public class ME09SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int combinationNum = 0;
        boolean hasFound = false;

        for (int i = a; i <= b; i++) {
            for (int j = a; j <= b; j++) {
                combinationNum++;
                if (i + j == magicNum) {
                    hasFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combinationNum, i, j, i + j);
                    break;
                }
            }
            if (hasFound) {
                break;

            }
        }
        if (!hasFound) {
            System.out.printf("%d combinations - neither equals %d", combinationNum, magicNum);
        }
    }
}
