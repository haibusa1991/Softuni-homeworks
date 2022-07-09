package lecture04;

import java.util.Scanner;

public class L09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numNumbers = Integer.parseInt(scanner.nextLine());

        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            sumLeft+=value;
        }

        for (int i = 0; i < numNumbers; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            sumRight+=value;
        }

        if(sumLeft==sumRight){
            System.out.printf("Yes, sum = %d", sumLeft);
        } else {
            System.out.printf("No, diff = %d",Math.abs(sumLeft-sumRight));
        }
    }
}
