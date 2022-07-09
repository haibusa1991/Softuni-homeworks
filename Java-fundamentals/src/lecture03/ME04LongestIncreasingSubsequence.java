package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class ME04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getLongestSequence(scanner.nextLine()));
    }

    static String getLongestSequence(String inputString) {

        int[] input = convertToIntArray(inputString);
        int[] originalInput = Arrays.copyOf(input, input.length);
        int[] bestSequence = new int[0];
        for (int i = 0; i < input.length; i++) {
            int[] currentSequence = getLongestSequence(input);
            int biggestNumberIndex = getBiggestNumberIndex(input);

            int currentSequenceLen = currentSequence.length;
            int bestSequenceLen = bestSequence.length;
            if (currentSequenceLen > bestSequenceLen) {
                if (originalInput.length > 1) {
                    checkLastSequenceNum(currentSequence, originalInput);
                }
                bestSequence = currentSequence;
                input[biggestNumberIndex] = Integer.MIN_VALUE;
                i = 0;
                continue;
            }

            if (biggestNumberIndex != -1) {
                input[biggestNumberIndex] = Integer.MIN_VALUE;
            }
        }


        return getFormattedOutput(bestSequence);
    }

    private static void checkLastSequenceNum(int[] currentSequence, int[] originalInput) {
        int biggestNumIndex = getIndexOfElement(currentSequence[currentSequence.length - 1], originalInput);
        int biggestNum = currentSequence[currentSequence.length - 1];
        int nextBiggestNumIndex = getIndexOfElement(currentSequence[currentSequence.length - 2], originalInput);

        for (int i = biggestNumIndex; i > nextBiggestNumIndex; i--) {
            int currNum = originalInput[i];
            if (currNum > biggestNum) {
                currentSequence[currentSequence.length - 1] = currNum;
                break;
            }
        }


    }

    static int[] getLongestSequence(int[] array) {
        int[] result = new int[0];

        int largestNum = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > largestNum) {
                largestNum = j;
                int[] arr = Arrays.copyOf(result, result.length + 1);
                arr[arr.length - 1] = largestNum;
                result = arr;
            }
        }
        return result;
    }

    static int[] convertToIntArray(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static int getBiggestNumberIndex(int[] arr) {
        int largestIndex = -1;
        int largestNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestNum) {
                largestIndex = i;
                largestNum = arr[i];
            }
        }
        return largestIndex;
    }

    static String getFormattedOutput(int[] arr) {
        String output = "";
        for (int j : arr) {
            output += j + " ";
        }
//        output = output.trim();
        return output;
    }

    static int getIndexOfElement(int element, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                return i;
            }
        }
        return -1;
    }
}

