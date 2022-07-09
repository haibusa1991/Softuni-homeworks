package lecture09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME03PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] keys = scanner.nextLine().split("\\|");
        char[] capitalLetters = getCapitalLetters(keys[0]);
        int[] countTrailingSymbols = getCountTrailingSymbols(capitalLetters, keys[1]);
        String[] words = getWords(capitalLetters, countTrailingSymbols, keys[2]);
        Arrays.stream(words).forEach(System.out::println);
    }

    private static String[] getWords(char[] capitalLetters, int[] countTrailingSymbols, String key) {
        String[] words = key.split(" ");
        List<String> finalWords = new ArrayList<>();
        for (int i = 0; i < capitalLetters.length; i++) {
            for (String word : words) {
                if (word.length() == countTrailingSymbols[i]+1
                        && word.charAt(0) == capitalLetters[i]){
                    finalWords.add(word);
                }
            }
        }
        return finalWords.toArray(String[]::new);
    }

    private static int[] getCountTrailingSymbols(char[] capitalLetters, String key) {
        StringBuilder output = new StringBuilder();
        for (char currentLetter : capitalLetters) {
            Matcher matcher = Pattern.compile((int) currentLetter + ":[\\d]{2}").matcher(key);
            if (matcher.find()) {
                output.append(matcher.group()).append("!");
            }
        }
        return Arrays.stream(output.toString().split("!"))
                .map(e -> e.split(":")[1])
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static char[] getCapitalLetters(String input) {
        Matcher matcher = Pattern.compile("([#$%*&])(?<capitalLetters>[A-Z]+)\\1").matcher(input);
        if (matcher.find()) {
            return matcher.group("capitalLetters").toCharArray();
        }
        return new char[0];
    }
}
