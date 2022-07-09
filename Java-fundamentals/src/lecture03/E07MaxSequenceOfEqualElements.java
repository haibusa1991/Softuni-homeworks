package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int occurrenceIndex = 0;
        int maxOccurrences = 1;
        int currentOccurrences = 1;

        for (int i = 0; i < input.length; i++) {
            if (i + 1 < input.length && input[i] == input[i + 1]) {
                currentOccurrences++;
            } else if (currentOccurrences > maxOccurrences) {
                occurrenceIndex = i;
                maxOccurrences = currentOccurrences;
                currentOccurrences = 1;
            } else {
                currentOccurrences = 1;
            }
        }

        for (int i = 0; i < maxOccurrences; i++) {
            System.out.print(input[occurrenceIndex] + " ");
        }
    }

}
