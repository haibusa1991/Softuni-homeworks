package lecture04;

import java.util.Scanner;

public class L07SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        int numOfDigits = Integer.parseInt(scanner.nextLine());
        int sum=0;

        for (int i = 0; i < numOfDigits; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            sum+=input;
        }
        System.out.println(sum);
    }
}
