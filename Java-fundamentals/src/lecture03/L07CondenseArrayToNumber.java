package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class L07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        while (input.length > 1) {
            int[] condensedArray = new int[input.length - 1];
            for (int i = 0; i < input.length - 1; i++) {
                condensedArray[i] += input[i] + input[i + 1];
            }
            input = condensedArray;
        }
        System.out.println(input[0]);
    }
}
