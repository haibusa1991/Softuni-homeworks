package finalExamExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://judge.softuni.bg/Contests/Practice/Index/2525#0
public class FEE14AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        Matcher matcher = Pattern.compile("([|#])[A-Za-z ]+\\1\\d{2}/\\d{2}/\\d{2}\\1\\d+\\1").matcher(data);
        List<String> items = new ArrayList<>();
        while (matcher.find()) {
            items.add(formatFood(matcher.group()));
        }
        int totalCalories = 0;
        for (String item : items) {
            totalCalories += Integer.parseInt(item.split("Nutrition: ")[1]);
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        items.forEach(System.out::println);
    }

    private static String formatFood(String input) {
//        #Bread#19/03/21#4000#
//        |Apples|08/10/20|200|
        String[] data = input.replace("#", "|").split("\\|");
        return "Item: " + data[1] + ", Best before: " + data[2] + ", Nutrition: " + data[3];
    }


}
