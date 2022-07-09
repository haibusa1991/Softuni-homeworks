package lecture09;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalSum = 0;
        while (!input.equals("end of shift")) {
            totalSum += getSum(input);
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalSum);
    }

    private static double getSum(String input) {
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]+)\\|[^|$%.0-9]*(?<price>[0-9]+\\.?[0-9]*)\\$";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find()) {
            String name = matcher.group("name");
            String product = matcher.group("product");
            int quantity = Integer.parseInt(matcher.group("quantity"));
            double price = Double.parseDouble(matcher.group("price"));
            System.out.printf("%s: %s - %.2f%n", name, product, price*quantity);
            return price*quantity;
        }
        return 0;
    }


}
