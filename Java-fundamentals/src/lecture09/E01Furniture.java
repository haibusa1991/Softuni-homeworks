package lecture09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = ">>(?<furniture>\\w+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        double finalSum = 0;
        List<String> furniture = new ArrayList<>();
        while (!input.equals("Purchase")) {
            Matcher matcher = Pattern.compile(regex).matcher(input);
            if (matcher.find()) {
                furniture.add(matcher.group("furniture"));
                finalSum += Double.parseDouble(matcher.group("quantity")) * Double.parseDouble(matcher.group("price"));
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", finalSum);
    }
}
