package lecture09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> emails = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Za-z\\d]+[.\\-_]?[A-Za-z\\d]+@[A-Za-z]+-?[A-Za-z]+\\.[A-Za-z]+-?[A-Za-z]+[.A-Za-z-]*\\b").matcher(scanner.nextLine());
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        emails.forEach(System.out::println);
    }
}