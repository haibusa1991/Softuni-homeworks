package Workshop02;

import java.util.Arrays;
import java.util.Scanner;

public class L01RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(input, 0));
    }

    private static int sum(int[] arr, int startIndex) {
        if (startIndex == arr.length - 1) {
            return arr[startIndex];
        }

        return arr[startIndex] + sum(arr, startIndex + 1);

    }
}
