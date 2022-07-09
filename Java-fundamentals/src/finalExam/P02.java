package finalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = Pattern.compile("^([$%])[A-Z][a-z]{2,}\\1: (\\[\\d+\\]\\|){3}$").matcher(input);
            if (matcher.find()) {
                decode(matcher.group());
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }

    private static void decode(String group) {
        StringBuilder output = new StringBuilder();
        String command = group.split(": ")[0].replaceAll("[\\$%]","");
        output.append(command).append(": ");
        String[] letters = group.split(": ")[1].replace("[", "").replace("]", "").split("\\|");
        for (String letter : letters) {
            output.append((char) Integer.parseInt(letter));
        }
        System.out.println(output);
    }


}
