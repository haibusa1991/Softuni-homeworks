package finalExamExcercise;
//https://judge.softuni.bg/Contests/Practice/Index/2302#0

import java.util.Scanner;

public class FEE01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawKey = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];
            switch (command) {
                case "Contains":
                    String substring = input.split(">>>")[1];
                    if (rawKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip": {
                    String letterCase = input.split(">>>")[1];
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int endIndex = Integer.parseInt(input.split(">>>")[3]);
                    String leftSection = rawKey.substring(0, startIndex);
                    String rightSection = rawKey.substring(endIndex);
                    String alteredSection;
                    if (letterCase.equals("Upper")) {
                        alteredSection = rawKey.substring(startIndex, endIndex).toUpperCase();
                    } else {
                        alteredSection = rawKey.substring(startIndex, endIndex).toLowerCase();
                    }
                    rawKey = leftSection + alteredSection + rightSection;
                    System.out.println(rawKey);
                    break;
                }
                case "Slice": {
                    int startIndex = Integer.parseInt(input.split(">>>")[1]);
                    int endIndex = Integer.parseInt(input.split(">>>")[2]);
                    String leftSection = rawKey.substring(0, startIndex);
                    String rightSection = rawKey.substring(endIndex);
                    rawKey = leftSection + rightSection;
                    System.out.println(rawKey);
                    break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + rawKey);
    }
}
