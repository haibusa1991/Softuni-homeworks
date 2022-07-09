package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class L06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int comparator = Arrays.mismatch(array1, array2);
        if (comparator == -1) {
            System.out.printf("Arrays are identical. Sum: %d", Arrays.stream(array1).sum());
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", comparator);
        }


        ;
    }
}
