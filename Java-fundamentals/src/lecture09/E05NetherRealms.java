package lecture09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> demonNames = Arrays.stream(scanner.nextLine().split("[, ]+")).collect(Collectors.toList());
        List<String> demonStats= new ArrayList<>();
        for (String demon : demonNames) {
            int health = getHealth(demon);
            double damage = getDamage(demon);
            demonStats.add(String.format("%s - %d health, %.2f damage", demon, health, damage));
        }
        demonStats.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);

    }

    private static double getDamage(String demon) {
        String pass1 = "\\-?[0-9]+\\.?[0-9]*";
        Matcher matcher1 = Pattern.compile(pass1).matcher(demon);
        double result = 0;
        while (matcher1.find()) {
            result += Double.parseDouble(matcher1.group());
        }
        String pass2 = "[/*]";
        Matcher matcher2 = Pattern.compile(pass2).matcher(demon);
        while (matcher2.find()) {
            String action = matcher2.group();
            if (action.equals("/")) {
                result /= 2;
            } else {
                result *= 2;
            }
        }
        return result;
    }

    private static int getHealth(String demon) {
        int health = 0;
        Matcher matcher = Pattern.compile("[^0-9+\\-*/.]").matcher(demon);
        while (matcher.find()) {
            health += matcher.group().charAt(0);
        }
        return health;
    }
}
