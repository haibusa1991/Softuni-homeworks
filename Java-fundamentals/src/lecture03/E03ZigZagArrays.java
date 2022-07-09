package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPairs = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[numPairs];
        int[] array2 = new int[numPairs];

        for (int i = 0; i < numPairs; i++) {
            int[] currentPair = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i % 2 == 0) {
                array1[i] = currentPair[0];
                array2[i] = currentPair[1];
            } else {
                array1[i] = currentPair[1];
                array2[i] = currentPair[0];
            }
        }
        for (int value : array1) System.out.print(value + " ");
        System.out.println();
        for (int value : array2) System.out.print(value + " ");

    }
}
