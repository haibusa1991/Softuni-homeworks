package lecture04;

import java.util.Scanner;

public class ME05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(getSignum(nums));
    }

    public static String getSignum(int[] arr) {
        int numNegatives = 0;
        boolean isZero = false;

        for (int j : arr) {
            if (j < 0) {
                numNegatives++;
            }
            if (j == 0) {
                isZero = true;
            }
        }

        if (isZero) {
            return "zero";
        } else if (numNegatives % 2 != 0) {
            return "negative";
        } else {
            return "positive";
        }


    }
}

