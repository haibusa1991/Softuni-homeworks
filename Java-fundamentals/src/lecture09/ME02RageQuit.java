package lecture09;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME02RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        StringBuilder spam = getSpam(input);
        System.out.println("Unique symbols used: " + spam.chars().distinct().count());
        System.out.println(spam);
    }

    private static StringBuilder getSpam(String input) {
        StringBuilder output = new StringBuilder();
        Matcher matcher = Pattern.compile("(?<letters>\\D*)(?<repetitions>\\d+)").matcher(input);
        while (matcher.find()) {
            output.append(matcher.group("letters").repeat(Integer.parseInt(matcher.group("repetitions"))));
        }
        return output;
    }
}
