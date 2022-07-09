package lecture09;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = decodeMessage(scanner.nextLine());
            String[] result = assertMessage(input);
            if (result[0].equals("D")) {
                destroyedPlanets.add(result[1]);
            } else if (result[0].equals("A")) {
                attackedPlanets.add(result[1]);
            }
        }
        System.out.print("Attacked planets: " + attackedPlanets.size() + "\n");
        attackedPlanets.stream().sorted().forEach(e -> System.out.println("-> " + e));
        System.out.print("Destroyed planets: " + destroyedPlanets.size() + "\n");
        destroyedPlanets.stream().sorted().forEach(e -> System.out.println("-> " + e));
    }

    private static String[] assertMessage(String input) {
        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*:[0-9]+[^@\\-!:>]*!(?<type>[A|D])![^@\\-!:>]*->[0-9]+";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            return new String[]{matcher.group("type"), matcher.group("name")};
        }
        return new String[]{"0", "0"};
    }

    private static String decodeMessage(String input) {
        String regex = "[starSTAR]";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        int value = (int) matcher.results().count();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) - value));
        }
        return output.toString();
    }

}