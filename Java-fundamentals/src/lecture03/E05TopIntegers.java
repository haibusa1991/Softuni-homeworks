package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < input.length; i++) {
            boolean isBigger = true;
            for (int j = i; j < input.length - 1; j++) {
                if (input[i] <= input[j + 1]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(input[i] + " ");
            }
        }

    }
}

