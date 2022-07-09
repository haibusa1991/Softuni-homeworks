package finalExamExcercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2525#0
public class FEE13TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] data = input.split("\\|");
            String command = data[0];
            switch (command) {
                case "Move":
                    int numLetters = Integer.parseInt(data[1]);
                    message.append(message.substring(0, numLetters)).delete(0, numLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(data[1]);
                    String value = data[2];
                    message.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = data[1];
                    String replacement = data[2];
                    while (message.indexOf(substring) != -1) {
                        message.replace(message.indexOf(substring), message.indexOf(substring) + replacement.length(), replacement);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        message.insert(0, "The decrypted message is: ");
        System.out.println(message);
    }
}
