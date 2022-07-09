package finalExamExcercise;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://judge.softuni.bg/Contests/Practice/Index/2302#1
public class FEE02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BigInteger coolness = getCoolness(input);
        System.out.println("Cool threshold: " + coolness);
        LinkedHashMap<String, Integer> emojis = getEmojis(input);
        System.out.println(emojis.size() + " emojis found in the text. The cool ones are:");
        emojis.entrySet().stream().filter(e -> coolness.compareTo(new BigInteger(String.valueOf(e.getValue()))) < 0).forEach(e -> System.out.println(e.getKey()));
    }

    private static BigInteger getCoolness(String input) {
        Matcher matcher = Pattern.compile("\\d").matcher(input);
        BigInteger output = BigInteger.ONE;
        while (matcher.find()) {
            BigInteger currentValue = new BigInteger(matcher.group());
            if (currentValue.equals(BigInteger.ZERO)) {
                return BigInteger.ZERO;
            }
            output = output.multiply(currentValue);
        }
        return output;
    }

    private static LinkedHashMap<String, Integer> getEmojis(String input) {
        Matcher matcher = Pattern.compile("(::|\\*\\*)[A-Z][a-z]{2,}\\1").matcher(input);
        LinkedHashMap<String, Integer> output = new LinkedHashMap<>();
        while (matcher.find()) {
            output.put(matcher.group(), getEmojiScore(matcher.group()));
        }
        return output;
    }

    private static int getEmojiScore(String emoji) {
        int score = 0;
        for (int i = 2; i < emoji.length() - 2; i++) {
            score += emoji.charAt(i);
        }
        return score;
    }
}
