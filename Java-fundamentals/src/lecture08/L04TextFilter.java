package lecture08;

import java.util.Scanner;

public class L04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        StringBuilder textToCensor = new StringBuilder(scanner.nextLine());
        for (String currentWord : bannedWords) {
            StringBuilder replacement = new StringBuilder(currentWord.length());
            replacement.append("*".repeat(currentWord.length()));
            while (textToCensor.indexOf(currentWord) != -1) {
                textToCensor.replace(textToCensor.indexOf(currentWord),
                        textToCensor.indexOf(currentWord) + currentWord.length(),
                        replacement.toString());
            }
        }
        System.out.println(textToCensor);

    }
}
