package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean isSolved = false;
        for (int i = 0; i < input.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i != 0) {
                int[] leftArray = Arrays.copyOfRange(input, 0, i);
                leftSum = Arrays.stream(leftArray).sum();
            }
            if (i != input.length - 1) {
                int[] rightArray = Arrays.copyOfRange(input, i + 1, input.length);
                rightSum = Arrays.stream(rightArray).sum();
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isSolved = true;
            }
        }
        if (!isSolved) {
            System.out.println("no");
        }
    }
}
