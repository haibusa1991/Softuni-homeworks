package lecture07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll("\\s+", "");
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (chars.containsKey(input.charAt(i))) {
                chars.put(input.charAt(i), chars.get(input.charAt(i)) + 1);
            } else {
                chars.put(input.charAt(i), 1);
            }
        }
        chars.forEach((e1, e2) -> System.out.println(e1 + " -> " + e2));

    }
}
