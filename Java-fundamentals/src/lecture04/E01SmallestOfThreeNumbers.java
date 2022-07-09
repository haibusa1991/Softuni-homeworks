package lecture04;

import java.util.Arrays;
import java.util.Scanner;

public class E01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(getSmallestNumber(nums));
    }

    static int getSmallestNumber(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
