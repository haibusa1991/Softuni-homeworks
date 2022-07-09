package finalExamExcercise;
//https://judge.softuni.bg/Contests/Practice/Index/2307#0
import java.util.Scanner;

public class FEE07SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String command = input.split(":\\|:")[0];
            switch (command) {
                case "InsertSpace": {
                    int index = Integer.parseInt(input.split(":\\|:")[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                }
                case "Reverse": {
                    String substring = input.split(":\\|:")[1];
                    if (message.indexOf(substring) == -1) {
                        System.out.println("error");
                        break;
                    }
                    message.replace(message.indexOf(substring), message.indexOf(substring) + substring.length(), "");
                    message.append(new StringBuilder(substring).reverse());
                    System.out.println(message);
                    break;
                }
                case "ChangeAll": {
                    String substring = input.split(":\\|:")[1];
                    String replacement = input.split(":\\|:")[2];
                    message = new StringBuilder(message.toString().replaceAll(substring, replacement));
                    System.out.println(message);
                    break;
                }
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
