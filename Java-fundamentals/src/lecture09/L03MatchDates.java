package lecture09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<day>\\d{2})([\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})";
        Matcher matcher= Pattern.compile(regex).matcher(scanner.nextLine());
        List<String> dates = new ArrayList<>();

        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",matcher.group("day"),
                    matcher.group("month"),matcher.group("year"));
        }
    }
}
