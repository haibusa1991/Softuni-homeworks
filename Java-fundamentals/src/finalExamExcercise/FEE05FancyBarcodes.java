package finalExamExcercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://judge.softuni.bg/Contests/Practice/Index/2303#1
public class FEE05FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = Pattern.compile("^@#+[A-Z][A-Za-z\\d]{4,}[A-Z]@#+").matcher(input);
            StringBuilder sb = new StringBuilder();
            if (matcher.find()) {
                Matcher matcher2 = Pattern.compile("\\d").matcher(input);
                while (matcher2.find()) {
                    sb.append(matcher2.group());
                }
                if (sb.length() == 0) {
                    sb.append("00");
                }
                System.out.println("Product group: " + sb);
            } else {
                System.out.println("Invalid barcode");
            }

        }

    }
}
