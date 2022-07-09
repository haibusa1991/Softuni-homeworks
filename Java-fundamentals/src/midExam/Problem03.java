package midExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chat = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String command = data[0];
            String message = data[1];
            switch (command) {
                case "Chat":
                    chat.add(message);
                    break;
                case "Delete":
                    chat.remove(message);
                    break;
                case "Edit":
                    if (chat.contains(message)) {
                        chat.set(chat.indexOf(message), data[2]);
                    }
                    break;
                case "Pin":
                    if (chat.contains(message)) {
                        chat.add(message);
                        chat.remove(message);
                    }
                    break;
                case "Spam":
                    chat.addAll(Arrays.asList(data).subList(1, data.length));
                    break;
            }
            input = scanner.nextLine();
        }
        chat.forEach(System.out::println);
    }
}
