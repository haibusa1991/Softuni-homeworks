package finalExamExcercise;

import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2303#0
public class FEE04PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        sb.append(password.charAt(i));
                    }
                    password = sb;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int length = Integer.parseInt(input.split(" ")[2]);
                    password.replace(index, index + length, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = input.split(" ")[1];
                    String substitute = input.split(" ")[2];
                    if (password.indexOf(substring) == -1) {
                        System.out.println("Nothing to replace!");
                    } else {
                        password = new StringBuilder(password.toString().replaceAll(substring, substitute));
                        System.out.println(password);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
