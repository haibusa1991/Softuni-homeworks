package lecture09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        List<String> goodChildren = new ArrayList<>();
        while (!input.equals("end")) {
            String message = decrypt(input, key);
            Matcher matcher = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<beh>.)!").matcher(message);
            if (matcher.find()) {
                if(matcher.group("beh").equals("G")) {
                    goodChildren.add(matcher.group("name"));
                }
            }
            input = scanner.nextLine();
        }
        goodChildren.forEach(System.out::println);
    }

    private static String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (char currentChar : input.toCharArray()) {
            output.append((char) (currentChar - key));
        }
        return output.toString();
    }
}
