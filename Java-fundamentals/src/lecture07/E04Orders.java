package lecture07;

import java.util.*;

public class E04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, double[]> items = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("buy")) {
            String currentItem = input.split(" ")[0];
            double currentPrice = Double.parseDouble(input.split(" ")[1]);
            int currentQuantity = Integer.parseInt(input.split(" ")[2]);

            if (!items.containsKey(currentItem)) {
                items.put(currentItem, new double[]{currentPrice, currentQuantity});
            } else {
                double[] values = items.get(currentItem);
                values[0] = currentPrice;
                values[1] += currentQuantity;
                items.put(currentItem, values);
            }
            input = scanner.nextLine();
        }
        items.forEach((e1, e2) -> System.out.printf("%s -> %.2f%n", e1, e2[0] * e2[1]));

    }
}
