package L03SetsAndMapsAdvanced;

import java.util.*;

public class L04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> numbers = new LinkedHashMap<>();

        String[] values = scanner.nextLine().split(" ");
        for (String value : values) {
            if (numbers.containsKey(value)) {
                numbers.put(value, numbers.get(value) + 1);
            } else {
                numbers.put(value, 1);
            }
        }
        numbers.entrySet().forEach(e -> System.out.printf("%.1f -> %d%n", Double.parseDouble(e.getKey()), e.getValue()));
    }
}
