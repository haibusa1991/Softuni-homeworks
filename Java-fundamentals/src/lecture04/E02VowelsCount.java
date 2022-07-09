package lecture04;

import java.util.Scanner;

public class E02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(getVowelsCount(input));
    }

    private static int getVowelsCount(String s) {
        int numVowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                numVowels++;
            }
        }
        return numVowels;
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'a':
            case 'o':
            case 'u':
            case 'e':
            case 'i':
                return true;
        }
        return false;
    }
}
