package Workshop02;

import java.util.Arrays;
import java.util.Scanner;

public class L05MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(mergeSort(arr)));

    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int halfIndex = array.length / 2;
        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = firstArrayLength; i < firstArrayLength + secondArrayLength; i++) {
            secondPartition[i-firstArrayLength] = array[i];

        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        int mainIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstArrayLength && secondIndex < secondArrayLength) {
            if (firstPartition[firstIndex] < secondPartition[secondIndex]) {
                array[mainIndex] = firstPartition[firstIndex];
                mainIndex++;
                firstIndex++;
            } else {
                array[mainIndex] = secondPartition[secondIndex];
                mainIndex++;
                secondIndex++;
            }
        }

        while (firstIndex < firstArrayLength) {
            array[mainIndex] = firstPartition[firstIndex];
            mainIndex++;
            firstIndex++;
        }
        while (secondIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondIndex];
            mainIndex++;
            secondIndex++;
        }
        return array;
    }
}
