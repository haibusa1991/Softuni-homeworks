package lecture08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ME03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] key = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<String> treasures = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("find")) {
            treasures.add(decode(input, key));
            input = scanner.nextLine();
        }
        treasures.forEach(e -> System.out.println(formatTreasure(e)));
    }

    private static String decode(String input, int[] key) {
        StringBuilder output = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            currentChar -= key[i % key.length];
            output.append(currentChar);
        }
        return output.toString();
    }

    private static String formatTreasure(String input) {
        String treasure = input.split("&")[1];
        String coordinates = input.split("<")[1].split(">")[0];
        return "Found " + treasure + " at " + coordinates;
    }
}
