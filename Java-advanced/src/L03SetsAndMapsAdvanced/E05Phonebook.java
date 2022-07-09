package L03SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            phonebook.put(tokens[0], tokens[1]);
            input = scanner.nextLine();
        }
        String lookup = scanner.nextLine();
        while (!lookup.equals("stop")) {
            System.out.println(phonebook.containsKey(lookup)
                    ? lookup + " -> " + phonebook.get(lookup)
                    : "Contact " + lookup + " does not exist.");
            lookup = scanner.nextLine();
        }
    }
}
