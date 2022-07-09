package lecture07;

import java.util.*;

public class L02WordSynonyms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numInputs = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> words = new LinkedHashMap<>();
        for (int i = 0; i < numInputs; i++) {
            String key = scanner.nextLine();
            String value = scanner.nextLine();
            if (!words.containsKey(key)) {
                words.put(key, new ArrayList<>());
            }
            words.get(key).add(value);
        }
        words.forEach((e1, e2) -> System.out.print(e1 + " - " + e2.toString().replaceAll("[\\[\\]]", "") + "\n"));
    }
}
