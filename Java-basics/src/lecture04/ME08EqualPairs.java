package lecture04;

import java.util.Scanner;

public class ME08EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPairs = Integer.parseInt(scanner.nextLine());

        int targetSum = 0;
        boolean isFirstRun = true;
        int maxDifference = 0;
        int previousSum = 0;

        for (int i = 0; i < numPairs; i++) {
            int value1 = Integer.parseInt(scanner.nextLine());
            int value2 = Integer.parseInt(scanner.nextLine());

            if (isFirstRun) {
                targetSum = value1 + value2;
                previousSum = targetSum;
                isFirstRun = false;
            }

            if (targetSum != value1 + value2) {
                int diff = Math.abs((value1 + value2)-previousSum);
                if (maxDifference < diff) {
                    maxDifference = diff;
                }
            }
            previousSum=value1+value2;
        }
        if(maxDifference==0){
            System.out.printf("Yes, value=%d",targetSum);
        }else {
            System.out.printf("No, maxdiff=%d",maxDifference);
        }
    }
}
