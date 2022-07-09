package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class ME01EncryptSortPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStrings = Integer.parseInt(scanner.nextLine());
        int[] output = new int[numStrings];
        for (int i = 0; i < numStrings; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                boolean isVowel = false;
                switch (currentChar) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        isVowel = true;
                }
                if (isVowel) {
                    output[i] += currentChar * input.length();
                } else {
                    output[i] += currentChar / input.length();
                }
            }
        }
        Arrays.sort(output);
        for (int value : output) {
            System.out.println(value);
        }
    }
}