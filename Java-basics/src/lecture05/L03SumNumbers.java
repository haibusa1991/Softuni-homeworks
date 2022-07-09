package lecture05;

import java.util.Scanner;

public class L03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetSum = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int input = 0;
        while (sum < targetSum) {

            input = Integer.parseInt(scanner.nextLine());
            sum += input;
        }
        System.out.printf("%d", sum);
    }
}
