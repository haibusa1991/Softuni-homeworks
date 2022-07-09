package finalExamExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://judge.softuni.bg/Contests/Practice/Index/2307#1
public class FEE08MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Matcher matcher = Pattern.compile("([@#])[A-Za-z]{3,}\\1{2}[A-Za-z]{3,}\\1").matcher(input);
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group());
        }
        if (results.isEmpty()) {
            System.out.println("No word pairs found!\nNo mirror words!");
        } else {
            System.out.println(results.size() + " word pairs found!");
            List<String> mirrorWords = new ArrayList<>();
            results.forEach(e -> {
                String currentMatch= e.replaceAll("##"," ")
                        .replaceAll("@@"," ")
                        .replaceAll("[@#]","");
                String[] words = currentMatch.split(" ");
                StringBuilder sb = new StringBuilder(words[1]);
                if (words[0].equals(sb.reverse().toString())) {
                    mirrorWords.add(words[0] + " <=> " + words[1]);
                }
            });
            if (mirrorWords.isEmpty()) {
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                System.out.println(mirrorWords.toString().replaceAll("[\\[\\]]", ""));
            }
        }
    }
}
