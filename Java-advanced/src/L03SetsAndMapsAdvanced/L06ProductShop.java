package L03SetsAndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] data = input.split(", ");
            String shopName = data[0];
            String good = data[1];
            double price = Double.parseDouble(data[2]);
            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(good, price);
            input = scanner.nextLine();
        }

        shops.forEach((shopName, products) -> {
            System.out.println(shopName + "->");
            products.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f\n", product, price);
            });
        });
    }
}
