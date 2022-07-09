package lecture07;

import java.util.*;

public class L03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> values = new LinkedHashMap<>();
        for (String currentValue : input) {
            currentValue=currentValue.toLowerCase();
            if (values.containsKey(currentValue)) {
                values.put(currentValue, values.get(currentValue) + 1);
            } else {
                values.put(currentValue, 1);
            }
        }
        List<String> output = new ArrayList<>();
        values.forEach((e1, e2) -> {
            if (e2 % 2 != 0) {
                output.add(e1);
            }
        });
        System.out.println(output.toString().replaceAll("[\\[\\]]",""));
    }
}
