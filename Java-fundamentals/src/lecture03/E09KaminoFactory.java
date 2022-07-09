package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E09KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dnaLen = Integer.parseInt(scanner.nextLine());
        String currentInput = "";
        String[] samples = new String[0];
        while (true) {
            currentInput = scanner.nextLine();
            if (currentInput.equalsIgnoreCase("clone them!")) {
                break;
            }
            samples = Arrays.copyOf(samples, samples.length + 1);
            samples[samples.length - 1] = "";
            for (int i = 0; i < currentInput.length(); i++) {
                if (Character.isDigit(currentInput.charAt(i))) {
                    samples[samples.length - 1] += currentInput.charAt(i);
                }
            }
        }

        int bestSample = 0;
        int bestNumOnes = 0;
        int bestIndex = 0;
        int bestScore = 0;

        for (int i = 0; i < samples.length; i++) {
            String sample = samples[i];
            int currentIndex = 0;
            int currentScore = 0;
            for (int j = 0; j < sample.length(); j++) {
                currentScore += Integer.parseInt(String.valueOf(sample.charAt(j)));
            }
            int currentSampleOnes = 0;
            int maxCurrentSampleOnes = 0;
            int startingIndex = 0;
            for (int j = 0; j < dnaLen; j++) {
                if (sample.charAt(j) == '1') {
                    currentSampleOnes++;
                    startingIndex = j - currentSampleOnes + 1;
                }

                if (sample.charAt(j) == '0' || j == dnaLen - 1) {
                    if (currentSampleOnes > maxCurrentSampleOnes) {
                        maxCurrentSampleOnes = currentSampleOnes;
                        currentIndex = startingIndex;
                    }
                    currentSampleOnes = 0;
                }
            }
            if ((maxCurrentSampleOnes > bestNumOnes)
                    || (maxCurrentSampleOnes == bestNumOnes && currentIndex < bestIndex)
                    || (maxCurrentSampleOnes == bestNumOnes && currentIndex == bestIndex && currentScore > bestScore)) {
                bestSample = i;
                bestNumOnes = maxCurrentSampleOnes;
                bestIndex = currentIndex;
                bestScore = currentScore;
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSample + 1, bestScore);
        for (int i = 0; i < samples[bestSample].length(); i++) {
            System.out.print(samples[bestSample].charAt(i) + " ");
        }
    }
}

